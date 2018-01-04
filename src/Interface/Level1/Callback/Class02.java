package Interface.Level1.Callback;

import java.util.Date;

public class Class02 {
    void FetchDataFrmNet(InterfaceWorld_02.Service service) throws Exception{
        for(int i = 0;i<5;i++){
            Thread.sleep(1500);
            Date date = new Date();
            System.out.println("Application is trying to fetch the data from internet " + (date.getHours())+":"+date.getMinutes()+":"+date.getSeconds());
        }
        service.sucess(true);
    }
}
