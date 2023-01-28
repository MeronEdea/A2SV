class Solution {
    public List<Integer> pancakeSort(int[] arr) {
         int n = arr.length;
    List<Integer> res = new LinkedList<>();
    for(int i = n - 1; i >= 0; i--){
        if(arr[i] == i + 1) continue;
        int index = find(arr, i + 1);
        res.add(index);
        update(arr, index - 1);
        res.add(i + 1);
        update(arr, i);
    }
    return res;
    }
    int find(int[] arr, int v){
    for(int i = 0; i< arr.length; i++){
        if(arr[i] == v){
            return i + 1;
        }
    }
    return 1;
}

void update(int[] arr, int index){
    int l = 0, r = index;
    while(l < r){
        int t = arr[l];
        arr[l] = arr[r];
        arr[r] = t;
        l++;
        r--;
    }
}
}
