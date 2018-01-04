package Interface.Level1.Callback;

public class InterfaceWorld_02 {
    public static void main(String[] args) throws Exception {
        Service service = new Service() {
            @Override
            public void sucess(Boolean success) {
                if (success) {
                    System.out.println("Successfully Fetch the data from internet");
                }
            }
        };
        new Class02().FetchDataFrmNet(service);
    }


    public interface Service {
        void sucess(Boolean success);
    }
}
