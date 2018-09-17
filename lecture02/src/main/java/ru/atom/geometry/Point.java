package ru.atom.geometry;

/**
 * Template class for
 */
public class Point implements Collider/* super class and interfaces here if necessary */ {
    // fields

    private int[] coordinates;

    // and methods

    Point(int x, int y){
        this.coordinates=new int[]{x, y};
    }

    @Override
    public boolean isColliding(Collider other){
        if (other == null) return false;
        //Point Point
        if (this.equals(other)) return true;
        //Point Bar
        if (other.getClass()== (new Bar(new Point(0,1),new Point(0,1))).getClass() ) return other.isColliding(this);

        return false;
    }

    public int[] getCoorginates(){
        return new int[]{coordinates[0], coordinates[1]};
    }

    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;

        // cast from Object to Point
        Point point = (Point) o;

        // my code here
        
        if((point.coordinates[0]==this.coordinates[0])&&(point.coordinates[1]==this.coordinates[1])) return true;
        return false;

        //throw new UnsupportedOperationException();
    }
}
