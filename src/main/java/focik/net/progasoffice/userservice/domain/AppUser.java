package focik.net.progasoffice.userservice.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private boolean enabled;
    private boolean tokenExpired;
    private Date joinDate;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;

    @Override
    public String toString() {
        return  username;
    }

    @Column(name = "is_not_locked")
    private boolean notLocked;
    private Integer idEmployee;
    private Integer idDesigner;
//    private boolean isNotLocked;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
//    @JoinTable(
//            name = "users_privileges",
//            joinColumns = @JoinColumn(
//                    name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name = "privilege_id", referencedColumnName = "id"))
    private List<Privilege> privileges;


    public void addPrivilege(Privilege privilege){
        this.privileges.add(privilege);
    }

    public void deletePrivilege(Privilege privilege) {
        privileges.remove(privilege);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getGrantedAuthorities(getPrivileges(privileges));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return notLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEmployee(){
        return idEmployee != 0;
    }

    public boolean isDesigner(){
        return idDesigner != 0;
    }

    public boolean isAdmin(){
        Optional<Privilege> isAdmin = getPrivileges().stream()
                .filter(privilege -> "ROLE_ADMIN".equals(privilege.getRole().getName()))
                .findFirst();
        return isAdmin.isPresent();
    }
    private List<String> getPrivileges(Collection<Privilege> privileges) {

        List<String> privilegesList = new ArrayList<>();
        for (Privilege privilege : privileges) {
            privilegesList.add(privilege.getRole().getName());
            privilegesList.add(privilege.getFullReadName());
            privilegesList.add(privilege.getFullWriteName());
            privilegesList.add(privilege.getFullDeleteName());
        }
        return privilegesList;
    }
    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
