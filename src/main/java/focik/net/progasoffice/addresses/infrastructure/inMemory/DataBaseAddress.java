package focik.net.progasoffice.addresses.infrastructure.inMemory;


import focik.net.progasoffice.addresses.infrastructure.dto.AddressDbDto;

import java.util.HashMap;
import java.util.Map;


public class DataBaseAddress {
    private static HashMap<Long, AddressDbDto> addressDbDtoHashMap;

    public static Map<Long, AddressDbDto> getAddressHashMap() {
        if (addressDbDtoHashMap == null)
            addressDbDtoHashMap = new HashMap<>();
        return addressDbDtoHashMap;
    }


    private DataBaseAddress() {
    }
}
