package focik.net.progasoffice.tasks.common.domain.model;

import focik.net.progasoffice.tasks.gasconnection.domain.model.GasConnection;

public interface Stageable {
    Stage  calculateStage();
}
