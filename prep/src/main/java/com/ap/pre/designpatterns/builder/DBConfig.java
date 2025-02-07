package com.ap.pre.designpatterns.builder;

public class DBConfig {

    private final String host;
    private final int port;
    private final String username;
    private final boolean enableSSL;


    private DBConfig(DBConfigBuilder builder){

        this.host = builder.host;
        this.port = builder.port;
        this.username = builder.username;
        this.enableSSL = builder.enableSSL;

    }
    public static class DBConfigBuilder{
        private final String host;
        private int port;
        private String username;
        private boolean enableSSL;
        
        public DBConfigBuilder(String host, String username){
            this.host = host;
        }

        public DBConfigBuilder setport(int port){
            this.port = port;
            return this;
        }

        public DBConfig build(){
            return new DBConfig(this);
        }
        


}

public static void main(String[] args) {
    DBConfig config = new DBConfig.DBConfigBuilder("localhost", "username")
                                .setport(8080)
                                .build();
}

}


    







