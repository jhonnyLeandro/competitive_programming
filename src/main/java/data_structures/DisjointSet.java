package data_structures;

public class DisjointSet {
    private int parent[];
    private int rank[];

    DisjointSet(int numberOfSets) {
        parent = new int[numberOfSets + 1 ];
        rank= new int[numberOfSets + 1];
        createSets(numberOfSets);
    }

    void createSets(int numberOfSets){
        for (int i = 1; i <= numberOfSets; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    void mergeSets(int x, int y){
        int parentx = findSet(x);
        int parenty = findSet(y);

        if (rank[parentx] > rank[parenty]){
            parent[parenty] = parentx;
            rank[parentx] +=1;
        } else {
            parent[parentx] = parenty;
            rank[parenty]+=1;
        }
    }

    int findSet(int set){
        parent[set]= set != parent[set]?findSet(parent[set]):parent[set];
        return parent[set];
    }
}
