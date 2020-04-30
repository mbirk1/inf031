public class Star_database {
    private Star[] stars = new Star[0];

    public void add(Star star) {
        star.setDatabase(this);
        Star[] tmp = new Star[stars.length + 1];
        for (int i = 0; i < stars.length; i++) {
            tmp[i] = stars[i];
        }
        tmp[stars.length] = star;
        stars = tmp;
    }

    public void remove(int index) {
        Star[] tmp = new Star[stars.length - 1];
        int j = 0;
        for (int i = 0; i < stars.length; i++) {
            if (i != index) {
                tmp[j] = stars[i];
                j++;
            }
        }
        stars = tmp;
    }

    public Star get(int index) {
        return stars[index];
    }

    public int size() {
        return stars.length;
    }

    public Star find(String id) {
        for (Star star : stars) {
            if (star.getId().equals(id)) {
                return star;
            }
        }
        return null;
    }

    public void method() {
    }
}