public class Pflanzen_Tiere {
    public String name = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Pflanzen extends Pflanzen_Tiere {
        public String Beschreibung = null;

        public void setBeschreibung(String beschreibung) {
            this.Beschreibung = beschreibung;
        }

        public String getBeschreibung() {
            return Beschreibung;
        }
    }

    public static class Tiere extends Pflanzen_Tiere {

        public String[] pf_futter = new String[9];
        public String[] f_futter = new String[9];

        public int aufrufe_pf = 0;
        public int aufrufe_f = 0;


        public String[] getPf_Futter() {
            return pf_futter;
        }

        public String[] getF_Futter() {
            return f_futter;
        }

        public boolean isPflanzenfresser() {
            if (this.pflanze() && !this.fleisch()) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isFleischfresser() {
            if (!this.pflanze() && this.fleisch()) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isAllesfresser() {
            if (this.pflanze() && this.fleisch()) {
                return true;
            } else {
                return false;
            }
        }

        public void setPf_futter(String pflanze) {
            if (aufrufe_pf > pf_futter.length) {
                aufrufe_pf = 0;
                pf_futter[aufrufe_pf] = pflanze;
                aufrufe_pf = aufrufe_pf + 1;
            } else {
                pf_futter[aufrufe_pf] = pflanze;
                aufrufe_pf = aufrufe_pf + 1;
            }
        }

        public void setF_futter(String Fleisch) {
            if (aufrufe_f > f_futter.length) {
                aufrufe_f = 0;
                f_futter[aufrufe_f] = Fleisch;
                aufrufe_f = aufrufe_f + 1;

            } else {
                f_futter[aufrufe_f] = Fleisch;
                aufrufe_f = aufrufe_f + 1;
            }
        }

       public boolean pflanze() {
            for (int i = 0; i < pf_futter.length; i++) {
                if (pf_futter[i] != null) {
                    return true;
                }
            }
            return false;
        }

        public boolean fleisch() {
            for (int i = 0; i < f_futter.length; i++) {
                if (f_futter[i] != null) {
                    return true;
                }
            }
            return false;
        }

        public void ausgabe() {
            if (this.isPflanzenfresser()) {
                for (int i = 0; i < pf_futter.length; i++) {
                    if (this.pf_futter[i] != null) {
                        System.out.println(this.getName() + " frisst " + this.pf_futter[i]);

                    }
                }
            }

            if (this.isFleischfresser()) {
                for (int i = 0; i < f_futter.length; i++) {
                    if (this.f_futter[i] != null) {
                        System.out.println(this.getName() + " frisst " + this.f_futter[i]);

                    }
                }
            }
            if (this.isAllesfresser()) {
                for (int i = 0; i < pf_futter.length; i++) {
                    if (this.pf_futter[i] != null) {
                        System.out.println(this.getName() + " frisst " + this.pf_futter[i]);
                    }
                }
                for (int i = 0; i < f_futter.length; i++) {
                    if (this.f_futter[i] != null) {
                        System.out.println(this.getName() + " frisst " + this.f_futter[i]);
                    }
                }
            }

        }

    }
}