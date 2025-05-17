package org.taller.moduloDeComercio.dominio;

import jakarta.persistence.Id;

    public class POS {
        @Id
        private int idPOS;
        private boolean habilitadoPOS;

        public POS(int id) {
            this.idPOS = id;
            this.habilitadoPOS = false;
        }

        public int getIdPOS() {
            return idPOS;
        }

        public boolean getHabilitadoPOS(){
            return habilitadoPOS;
        }

        public void setIdPOS(int id) {
            this.idPOS = id;
        }

        public void setHabilitadoPOS(boolean habilitado){
            this.habilitadoPOS = habilitado;
        }

}
