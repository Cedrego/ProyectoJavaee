package org.taller.moduloDeComercio.dominio;

import jakarta.persistence.Id;

    public class POS {
        @Id
        private int idPOS;
        private Comercio comercio;
        private boolean habilitadoPOS;

        public POS(int id, Comercio comercio) {
            this.idPOS = id;
            this.comercio=comercio;
            this.habilitadoPOS = false;
        }

        public int getIdPOS() {
            return idPOS;
        }
        
        public Comercio getComercio(){
            return comercio;
        }

        public boolean getHabilitadoPOS(){
            return habilitadoPOS;
        }

        public void setIdPOS(int id) {
            this.idPOS = id;
        }

        public void setComercio(Comercio comercio){
            this.comercio=comercio;
        }
        
        public void setHabilitadoPOS(boolean habilitado){
            this.habilitadoPOS = habilitado;
        }

}
