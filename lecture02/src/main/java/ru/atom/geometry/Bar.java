package ru.atom.geometry;

/**
 * Template class for
 */
public class Bar implements Collider/* super class and interfaces here if necessary */ {
    // fields

    private Point[] coordinates;

    // and methods

    Bar(Point f, Point s){
        Point tF, tS;
        {
            int fX, fY, sX, sY;
            
            if ((f.getCoorginates()[0]-s.getCoorginates()[0])>0){
                fX=s.getCoorginates()[0];
                sX=f.getCoorginates()[0];
            }
            else{
                fX=f.getCoorginates()[0];
                sX=s.getCoorginates()[0];
            }

            if ((f.getCoorginates()[1]-s.getCoorginates()[1])>0){
                fY=s.getCoorginates()[1];
                sY=f.getCoorginates()[1];
            }
            else{
                fY=f.getCoorginates()[1];
                sY=s.getCoorginates()[1];
            }

            tF = new Point(fX, fY);
            tS = new Point(sX, sY);
        }
        
        this.coordinates=new Point[]{tF, tS};
    }

    @Override
    public boolean isColliding(Collider other){
        if (other == null) return false;
        
        //Bar Point
        if (other.getClass()==(new Point(0,1)).getClass()){

            int[] oC =((Point) other).getCoorginates();
            int[][] tC=new int[][]{this.coordinates[0].getCoorginates(),this.coordinates[1].getCoorginates()};
            
            if(
                (
                    //X-------tC[0][0]--oC[0]--tC[1][0]-->?
                    (tC[0][0]<=oC[0])&&(oC[0]<=tC[1][0])
                )
                &&
                (   
                    //Y-------tC[0][1]--oC[1]--tC[1][1]-->?
                    (tC[0][1]<=oC[1])&&(oC[1]<=tC[1][1]))
                ) return true;
            return false;
        }

        //Bar Bar
        if (other.getClass()== this.getClass()){
            if (this.equals(other)) return true;

            Bar o=(Bar) other;

            {

                int[][] tC=new int[][]{this.coordinates[0].getCoorginates(),this.coordinates[1].getCoorginates()};
                int[][] oC=new int[][]{o.coordinates[0].getCoorginates(),o.coordinates[1].getCoorginates()};
                
                if(
                    (
                        (
                            //X-------tC[0][0]--oC[0][0]--tC[1][0]-->?
                            (tC[0][0]<=oC[0][0])&&(oC[0][0]<=tC[1][0])
                        )
                        ||
                        (
                            //X-------tC[0][0]--oC[1][0]--tC[1][0]-->?
                            (tC[0][0]<=oC[1][0])&&(oC[1][0]<=tC[1][0])
                        )
                        ||
                        (
                            //X-------oC[0][0]--tC[0][0]--oC[1][0]-->?
                            (oC[0][0]<=tC[0][0])&&(tC[0][0]<=oC[1][0])
                        )
                    )
                    &&
                    (
                        (
                            //Y-------tC[0][1]--oC[0][1]--tC[1][1]-->?
                            (tC[0][1]<=oC[0][1])&&(oC[0][1]<=tC[1][1])
                        )
                        ||
                        (
                            //Y-------tC[0][1]--oC[1][1]--tC[1][1]-->?
                            (tC[0][1]<=oC[1][1])&&(oC[1][1]<=tC[1][1])
                        )
                        ||
                        (
                            //Y-------oC[0][1]--tC[0][1]--oC[1][1]-->?
                            (oC[0][1]<=tC[0][1])&&(tC[0][1]<=oC[1][1])
                        )
                    )
                )return true;
                return false;
            }
        }
        return other.isColliding(this);
    }

    

    /**
     * @param other - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object other) {

        if (this == other) return true;
        if ((other == null) || (this.getClass() != other.getClass())) return false;

        // cast from Object to Bar
        Bar o = (Bar) other;

        // my code here



        if ( this.coordinates[0].equals(o.coordinates[0])&& this.coordinates[1].equals(o.coordinates[1])) return true;
        return false;

        //throw new UnsupportedOperationException();
    }
}
