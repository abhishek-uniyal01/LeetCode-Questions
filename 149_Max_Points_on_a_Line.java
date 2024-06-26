class Solution {
    public int maxPoints(int[][] points) {
        int n=points.length;
        if(n<=2){
            return n;
        }
        int maxm=2;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int totalLines=2;
                for(int k=0;k<n;k++){
                    if(k!=i && k!=j){
                        if((points[j][1]-points[i][1])*(points[i][0]-points[k][0])==(points[i][1]-points[k][1])*(points[j][0]-points[i][0])) totalLines++;
                    }
                }
                maxm=Math.max(maxm,totalLines);
            }
        }
        return maxm;
    }
}
