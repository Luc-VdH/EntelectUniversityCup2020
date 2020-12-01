package UniversityCup.src;

public class Shape implements Comparable {
    public int id;
    public int box;
    public int capacity;
    
    public int quant = 0;
    public int [][] or0;
    public int [][] or1;
    public int [][] or2;
    public int [][] or3;

    public Shape(int id, int box, int capacity, int [][] or0, int [][] or1, int [][] or2, int [][] or3){
        this.id = id;
        this.box = box;
        this.capacity = capacity;
        this.or0 = or0;
        this.or1 = or1;
        this.or2 = or2;
        this.or3 = or3;
        
    }

    public int compareTo(Object o){
        Shape other = (Shape) o;
        double ratio1 = Math.random();
        double ratio2 = Math.random();

        
        if(ratio1 > ratio2){
            return -1;
        }else if(ratio1 < ratio2){
            return 1;
        }else{
            return 0;
        }

        // if(this.capacity > other.capacity){
        //     return -1;
        // }else if(this.capacity < other.capacity){
        //     return 1;
        // }else{
        //     return 0;
        // }
    }



    
}