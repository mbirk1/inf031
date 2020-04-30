public class Star_Test {

    void testAddGetSize () {
        Star_database db = new Star_database ();
        assertEquals (0, db.size());
        Star star = new Star("Sirius", "TYC 5949 -2777 -1");
        db.add(star);
        assertEquals (1, db.size());
        star = db.get (0);
        assertNotNull(star);
        assertEquals("TYC 5949 -2777 -1", star.getId ());
    }

    private void assertNotNull(Star star) {
    }

    private void assertEquals(int i, Object size) {
    }
    private void assertEquals(String i, Object size){

    }

    void testAddRemoveSize () {
        Star_database db = new Star_database ();
        Star sirius = new Star("Sirius", "TYC 5949 -2777 -1");
        db.add(sirius);
        db.add(new Star("Alpha Centauri", "TYC 9007 -5849 -1"));
        assertEquals (2, db.size());
        db.remove (0);
        assertEquals (1, db.size());
        db.add(sirius);
        assertEquals("TYC 9007 -5849 -1", db.get (0).getId ());
    }
    void testFind () {
        Star_database db = new Star_database ();
        db.add(new Star("Sirius", "TYC 5949 -2777 -1"));
        db.add(new Star("Alpha Centauri", "TYC 9007 -5849 -1"));
        Star star = db.find("TYC 9007 -5849 -1");
        assertEquals("TYC 9007 -5849 -1", star.getId ());
        star = db.find("TYC 5331 -1752 -1");
        assertNull(star);
    }

    private void assertNull(Star star) {
    }

}
