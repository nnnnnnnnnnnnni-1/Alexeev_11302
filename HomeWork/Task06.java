class Task06{
    public static void main(String[] args){

        int[][] array = {{1,1,1,0,1,0,1,0,0,1},{1,0,0,1,1,0,1,0,0,0},{0,0,1,0,1,1,1,1,0,1}
                        ,{1,0,0,1,1,0,1,0,0,0},{1,1,1,0,1,0,1,1,1,1},{1,0,1,1,1,0,1,0,1,1}
                        ,{0,1,0,1,0,0,1,1,1,0},{0,0,1,1,0,1,1,1,0,1},{1,0,0,1,1,0,1,0,0,0}
                        ,{1,1,0,1,1,0,1,0,1,0},{0,0,0,1,1,0,0,0,1,0},{0,1,1,1,0,0,0,0,1,1}
                        ,{0,1,1,1,0,0,0,0,1,1}};
        int coin = 0;
        int maxCoin = 0;
        int rememberindex1 = 0;
        int rememberindex2 = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = i+1; j < array.length; j++){
                coin = 0;
                for (int k = 0; k < 10; k++){
                    if (array[i][k] == array[j][k]){
                        coin++;
                        if (maxCoin < coin){
                            maxCoin = coin;
                            rememberindex1 = i;
                            rememberindex2 = j;
                        }
                    }
                }
            }
        }
        System.out.println(rememberindex1 + " " + rememberindex2 + " number of coincidenses: " + maxCoin);
    }
}