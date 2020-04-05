package uva_online_judge.data_structures;

public class DisjointSet {
    private int parent[];
    private int rank[];
    private int numOfDisjointSets;

    DisjointSet(int numberOfSets) {
        parent = new int[numberOfSets];
        rank = new int[numberOfSets];
        createSets(numberOfSets);
        numOfDisjointSets = numberOfSets;
    }

    private void createSets(int numberOfSets){
        for (int i = 0; i < numberOfSets; i++){
            parent[i] = i;
        }
    }

    public void mergeSets(int x, int y){
        if (!isSameSet(x,y)){

            numOfDisjointSets--;

            int parentx = findSet(x);
            int parenty = findSet(y);

            if (rank[parentx] > rank[parenty]){
                parent[parenty] = parentx;
                rank[parentx]++;
            } else {
                parent[parentx] = parenty;
                rank[parenty]++;
            }
        }
    }

    public int findSet(int set){
       return set == parent[set]? set : (parent[set] = findSet(parent[set]));
    }

    public int numDisjointSets(){
        return numOfDisjointSets;
    }

    public boolean isSameSet(int x, int y){
        return findSet(x) == findSet(y);
    }

    public int sizeOfSet(int set){
        int p = findSet(set);
        int size = 0;
        for(int i = 0; i < parent.length; i++){
            if(p == parent[i]){
                size++;
            }
        }
        return size;
    }

}
