package org.example.structural;

interface IteratorInterface {
    boolean hasNext();
    int getPos();
    Object next();
}

interface ContainerIterator {
    IteratorInterface getIterator();
}

class   CustomCollection implements ContainerIterator {

    public String[] name = {"Rishabh","Hero","Rajat","Simran","Arihant"};

    private class IterateNameCollection implements IteratorInterface {
        int curr_pos;
        @Override
        public boolean hasNext() {
            return curr_pos < name.length;
        }

        @Override
        public int getPos() {
            return curr_pos;
        }

        @Override
        public Object next() {
            if (this.hasNext())
                return name[curr_pos++];
            else
                return null;
        }
    }

    @Override
    public IteratorInterface getIterator() { return new IterateNameCollection(); }
}

public class NameIterator {

    public static void main(String[] args) {
        CustomCollection companyRepository = new CustomCollection();
        for (IteratorInterface it = companyRepository.getIterator(); it.hasNext(); ) {
            String data = (String) it.next();
            System.out.println("Data["+ it.getPos() +"] : " + data);
        }
    }
}