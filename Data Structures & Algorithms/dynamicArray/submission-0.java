class DynamicArray {
private int size;
private int[] arr;
private int capacity;

    public DynamicArray(int capacity) {
        this.capacity=capacity;
        this.size=0;
        this.arr=new int[capacity];

    }

    public int get(int i) {
return arr[i];
    }

    public void set(int i, int n) {
arr[i] = n;
    }

    public void pushback(int n) {
     if(size==capacity){
     resize();
    }
 arr[size]=n;
 size++;
}

    public int popback() {
 if(size>0){
    int val=arr[size-1];
    size--;
    return val;
 }
 return -1;
    }

    private void resize() {
this.capacity=this.capacity * 2;
int[] newArr=new int[this.capacity];
for(int i=0;i<this.size;i++){
    newArr[i]=this.arr[i];
}
    
this.arr=newArr ;
    }
    public int getSize() {
return size;
    }

    public int getCapacity() {
     return capacity;
    }
}
