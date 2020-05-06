abstract class VersatileLinkedList extends LinkedStringList{
    private LinkedStringListElement start;
    private VersatileLinkedList list;

    public void add(boolean value) {
        LinkedStringListElement elem = new LinkedStringListElement();
        if(value){
            elem.setValue("yes");
        }else{
            elem.setValue("no");
        }
        if (start == null) { // list is empty
            start = elem;
        } else {
            LinkedStringListElement tmp = start;
            while (tmp.getNext() != null) { // find last element
                tmp = tmp.getNext();
            }
            tmp.setNext(elem);
        }
    }
    public void add(LinkedStringList value) {
        for(int i = 0; i< value.size(); i++){
            LinkedStringListElement elem = new LinkedStringListElement();
            elem.setValue(value.get(i));
            if (start == null) { // list is empty
                start = elem;
            } else {
                LinkedStringListElement tmp = start;
                while (tmp.getNext() != null) { // find last element
                    tmp = tmp.getNext();
                }
                tmp.setNext(elem);
            }
        }
    }

    public void add(LinkedStringList value, int begin, int end) {
        for(int i = begin; i< end; i++){
            LinkedStringListElement elem = new LinkedStringListElement();
            elem.setValue(value.get(i));
            if (start == null) { // list is empty
                start = elem;
            } else {
                LinkedStringListElement tmp = start;
                while (tmp.getNext() != null) { // find last element
                    tmp = tmp.getNext();
                }
                tmp.setNext(elem);
            }
        }
    }

    public VersatileLinkedList reserve(LinkedStringList value){
        for(int i = value.size(); i>=0; i--){
            LinkedStringListElement elem = new LinkedStringListElement();
            elem.setValue(value.get(i));
            if (start == null) { // list is empty
                start = elem;
            } else {
                LinkedStringListElement tmp = start;
                while (tmp.getNext() != null) { // find last element
                    tmp = tmp.getNext();
                }
                tmp.setNext(elem);
            }
        }
        return list;
    }

    public boolean euqals(VersatileLinkedList value){
        int count=0;
        if(this.size()!= value.size()){
            return false;
        }else{
            for(int i = 0; i<= value.size(); i++){
                if(this.get(i)!= value.get(i)){
                    return false;
                }else{
                    count++;
                }
            }
        }
        if(count == value.size()){
            return true;
        }
    }
}
