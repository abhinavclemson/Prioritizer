import java.util.*;
import java.util.Collections;
import java.util.Random;
//Priortizer 1: If not in insertion phase, the contents are kept sorted according to the order.

class prior<T> implements Prioritizer<T>{
    //Declaring Arraylist to hold the data
    public ArrayList<T> list;
   // public ArrayList<T> list2;
    //phase is True if the Prioritizer is in Insertion phase and False ,if in Removal phase
    boolean isInInsertionPhase;
    Comparator<T> compareObj;
    int size=0;
    public void sort(){
        T min;
        int min_pos=0;

        for(int i =0 ; i< this.list.size(); i++){
            min = this.list.get(i);
            for(int j =i;j < this.list.size(); j++ ){
                if(this.compareObj.compare(min, this.list.get(j)) == 1){
                    min = this.list.get(j);
                    min_pos=j;
                }

            }
            T temp=this.list.get(i);
            this.list.set(i,min);
            this.list.set(min_pos,temp);

        }
    }
    prior(Comparator<T> comparator1){

        this.compareObj = comparator1;
        this.isInInsertionPhase = false;
    }
    //top to peek at the last element of the ArrayList
    public void top(){
        if(this.list.size()>0){
        int index=this.list.size()-1;
        System.out.println(this.list.get(index));
    }}

    public void insert(T i) {
        this.isInInsertionPhase = true;
        if(this.size==0 && isInsertionPhase()) {
            this.list = new ArrayList<>();
            this.list.add(i);
            this.size = this.size();
        }
        else if (isInsertionPhase())
            {
                if(this.size()>0) {
                    this.list.add(i);
                    this.size=this.size();
                }
        } else {
            System.out.println("Please Change the phase.");
        }
    }

    @Override
    public void removeNextInOrder() {
            if (this.list.size()>0){
                this.list.remove(this.list.get(0));
                this.sort();
            }

    }

    public void removeAny(){
        if(this.size()>=1){
            Random random=new Random();
            int rand=random.nextInt(this.size());
            this.list.remove(rand);
            this.sort();
        }
        else{
        this.list=new ArrayList<>();

    }}

    public int size(){
        return list.size();
    }

    public boolean isInsertionPhase(){
        return this.isInInsertionPhase==true;
    }

    public void changePhase(){
        if(this.isInInsertionPhase){
            this.isInInsertionPhase=false;

        }
        else{
            this.isInInsertionPhase=true;
        }
    }
}
