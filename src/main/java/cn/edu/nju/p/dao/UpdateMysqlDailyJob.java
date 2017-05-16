package cn.edu.nju.p.dao;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;


/**
 * 每天定时爬取股票插入数据库
 * 准备用quartz实现
 * Created by dc on 2017/5/14.
 */
public class UpdateMysqlDailyJob implements Job{

    public UpdateMysqlDailyJob(){

    }

    /**
     * 定时执行的任务
     * @param context
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
//        long start = System.currentTimeMillis();
        GetDataFromSinaUtil tool=GetDataFromSinaUtil.getInstance();
//        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
//        String code = dataMap.getString("code");
//        String market = dataMap.getString("market").toLowerCase();
        String[] codeList={"000001.sz","000025.sz","002484.sz","002116.sz","002013.sz","002032.sz","300030.sz","002442.sz","300165.sz","002030.sz","300038.sz","001696.sz","002038.sz","002313.sz","002156.sz","002259.sz","300089.sz","002550.sz","002033.sz","002175.sz","300139.sz","002227.sz","300149.sz","300173.sz","002423.sz","000032.sz","002393.sz","300023.sz","300132.sz","002477.sz","300141.sz","002109.sz","002373.sz","300054.sz","002143.sz","300121.sz","002258.sz","002106.sz","002228.sz","002140.sz","000035.sz","002049.sz","002136.sz","002530.sz","002224.sz","002132.sz","002007.sz","002041.sz","002144.sz","300096.sz","300081.sz","002216.sz","002045.sz","002148.sz","002542.sz","002022.sz","300136.sz","002443.sz","002546.sz","000029.sz","000021.sz","002488.sz","002086.sz","002480.sz","002112.sz","002547.sz","002145.sz","002002.sz","002514.sz","002147.sz","300169.sz","002531.sz","002549.sz","002164.sz","300051.sz","002187.sz","002113.sz","002314.sz","002345.sz","002298.sz","002487.sz","002554.sz","002171.sz","300007.sz","000036.sz","300027.sz","002378.sz","002397.sz","300145.sz","002432.sz","002446.sz","002009.sz","002377.sz","002188.sz","002346.sz","002342.sz","300058.sz","002325.sz","300062.sz","300172.sz","002508.sz","002010.sz","002456.sz","002452.sz","002322.sz","300176.sz","300108.sz","002117.sz","002511.sz","300069.sz","300090.sz","300061.sz","002339.sz","002515.sz","300065.sz","002270.sz","300130.sz","300020.sz","002149.sz","300123.sz","002543.sz","300094.sz","002059.sz","002457.sz","300134.sz","002453.sz","002321.sz","002244.sz","002429.sz","300166.sz","002082.sz","300082.sz","002448.sz","300112.sz","002183.sz","300185.sz","002286.sz","002449.sz","002535.sz","002366.sz","002483.sz","300002.sz","002263.sz","002389.sz","002413.sz","002162.sz","002310.sz","002558.sz","002251.sz","300037.sz","002500.sz","000401.sz","002510.sz","300114.sz","002102.sz","002173.sz","002176.sz","002092.sz","300009.sz","002409.sz","002425.sz","002519.sz","300092.sz","002315.sz","002359.sz","002279.sz","002005.sz","002476.sz","002403.sz","002516.sz","002341.sz","002455.sz","300005.sz","300034.sz","002165.sz","300156.sz","002528.sz","002318.sz","002369.sz","002316.sz","300066.sz","002283.sz","002560.sz","002137.sz","002261.sz","002274.sz","002473.sz","002334.sz","002361.sz","300097.sz","300100.sz","002416.sz","000019.sz","002306.sz","002503.sz","002105.sz","002197.sz","002420.sz","002376.sz","300050.sz","300073.sz","002329.sz","002018.sz","002526.sz","300018.sz","002179.sz","002428.sz","300083.sz","002068.sz","002177.sz","002100.sz","300147.sz","002559.sz","002034.sz","002050.sz","002011.sz","002230.sz","002235.sz","002499.sz","300105.sz","002398.sz","002202.sz","002518.sz","002338.sz","002238.sz","002372.sz","300187.sz","002226.sz","002353.sz","300171.sz","002539.sz","002395.sz","002459.sz","002272.sz","000034.sz","000030.sz","002356.sz","000039.sz","300102.sz","002207.sz","002472.sz","300152.sz","002495.sz","002355.sz","300026.sz","000031.sz","002271.sz","300144.sz","300125.sz","300049.sz","300041.sz","002247.sz","002019.sz","002532.sz","002037.sz","002053.sz","002451.sz","002232.sz","002081.sz","300180.sz","002111.sz","300143.sz","300160.sz","002384.sz","002195.sz","002468.sz","300086.sz","300116.sz","002418.sz","002357.sz","002254.sz","002121.sz","002077.sz","300183.sz","000157.sz","002098.sz","002504.sz","002311.sz","002255.sz","002412.sz","002211.sz","300168.sz","002134.sz","002127.sz","002123.sz","002536.sz","002551.sz","002215.sz","002061.sz","002138.sz","300055.sz","300148.sz","002065.sz","002072.sz","300113.sz","002496.sz","300117.sz","002463.sz","002203.sz","002161.sz","300151.sz","002362.sz","002380.sz","000010.sz","300017.sz","002287.sz","002566.sz","002250.sz","002352.sz","002349.sz","300015.sz","000402.sz","002299.sz","002246.sz","002265.sz","000016.sz","300098.sz","300104.sz","002184.sz","002210.sz","002365.sz","002312.sz","002293.sz","002170.sz","002220.sz","300059.sz","002304.sz","000028.sz","000150.sz","002199.sz","002097.sz","002206.sz","002374.sz","002275.sz","000158.sz","002172.sz","002290.sz","002191.sz","300177.sz","002133.sz","002436.sz","002407.sz","300093.sz","002333.sz","300140.sz","002248.sz","000301.sz","002043.sz","000040.sz","002016.sz","300033.sz","002427.sz","002054.sz","002001.sz","002439.sz","300101.sz","000004.sz","002058.sz","002541.sz","002071.sz","002556.sz","002128.sz","002394.sz","002096.sz","300120.sz","002085.sz","002057.sz","002069.sz","300042.sz","002467.sz","002026.sz","002101.sz","002390.sz","002088.sz","002178.sz","300006.sz","002475.sz","002337.sz","002222.sz","300003.sz","300014.sz","002424.sz","002243.sz","002155.sz","002282.sz","002445.sz","002523.sz","002094.sz","002396.sz","002120.sz","300126.sz","002522.sz","002006.sz","002029.sz","002062.sz","002469.sz","300019.sz","300137.sz","002385.sz","002297.sz","002491.sz","300129.sz","300016.sz","002212.sz","002055.sz","000159.sz","002040.sz","002231.sz","002151.sz","002509.sz","002169.sz","002252.sz","002083.sz","002323.sz","002370.sz","002405.sz","300109.sz","002485.sz","002186.sz","002110.sz","002305.sz","002208.sz","002431.sz","300013.sz","002168.sz","300106.sz","002139.sz","002533.sz","300080.sz","002152.sz","002354.sz","002302.sz","000014.sz","002320.sz","002291.sz","002285.sz","002262.sz","002080.sz","000017.sz","002557.sz","002089.sz","000100.sz","002497.sz","002012.sz","002308.sz","002489.sz","002157.sz","002326.sz","000155.sz","002047.sz","002180.sz","300164.sz","300021.sz","000153.sz","000011.sz","002189.sz","002108.sz","300064.sz","002052.sz","002129.sz","300124.sz","002408.sz","002507.sz","002465.sz","300057.sz","002154.sz","300010.sz","002236.sz","002505.sz","002462.sz","002502.sz","002196.sz","002294.sz","002093.sz","002368.sz","002388.sz","002239.sz","000027.sz","002404.sz","002074.sz","002234.sz","002289.sz","300184.sz","002433.sz","300075.sz","300072.sz","002330.sz","300035.sz","002490.sz","001896.sz","300181.sz","002223.sz","002426.sz","002046.sz","002534.sz","300084.sz","002229.sz","002561.sz","002479.sz","300047.sz","002383.sz","002437.sz","300157.sz","002066.sz","002440.sz","002237.sz","300110.sz","002163.sz","002240.sz","002340.sz","002014.sz","002348.sz","002303.sz","002421.sz","002382.sz","002063.sz","002391.sz","000338.sz","002242.sz","002517.sz","300022.sz","300099.sz","000023.sz","002204.sz","002194.sz","002363.sz","300155.sz","002364.sz","002260.sz","000020.sz","002471.sz","002027.sz","002548.sz","002464.sz","300178.sz","002411.sz","300119.sz","000022.sz","002482.sz","002003.sz","002454.sz","300078.sz","000037.sz","002414.sz","002103.sz","002004.sz","002020.sz","002381.sz","002015.sz","300063.sz","002146.sz","002060.sz","002023.sz","002078.sz","002565.sz","300163.sz","002460.sz","300161.sz","300001.sz","002126.sz","002017.sz","002406.sz","002131.sz","300039.sz","002417.sz","002317.sz","300133.sz","300067.sz","300175.sz","002527.sz","300077.sz","002219.sz","002434.sz","300024.sz","002091.sz","002192.sz","002379.sz","300043.sz","002524.sz","002153.sz","002347.sz","002415.sz","002332.sz","300032.sz","300074.sz","002076.sz","002470.sz","002025.sz","002039.sz","002042.sz","002358.sz","002181.sz","002142.sz","002249.sz","002125.sz","002159.sz","002444.sz","002458.sz","002124.sz","002167.sz","000151.sz","002073.sz","300150.sz","002214.sz","000400.sz","002540.sz","002218.sz","300056.sz","002070.sz","002135.sz","002350.sz","300070.sz","300127.sz","300153.sz","002520.sz","300029.sz","002118.sz","002035.sz","002447.sz","002185.sz","002513.sz","002386.sz","002555.sz","002301.sz","002278.sz","300167.sz","002190.sz","002538.sz","300122.sz","000012.sz","002245.sz","002280.sz","002104.sz","002114.sz","002295.sz","300135.sz","002095.sz","002493.sz","002205.sz","300025.sz","300158.sz","300076.sz","300186.sz","300085.sz","002438.sz","300071.sz","300053.sz","002461.sz","002309.sz","300004.sz","002288.sz","002266.sz","002200.sz","300008.sz","002474.sz","002375.sz","300046.sz","300031.sz","002400.sz","002422.sz","002399.sz","300040.sz","002360.sz","000002.sz","002435.sz","002401.sz","002256.sz","002087.sz","002481.sz","002506.sz","002253.sz","000033.sz","002367.sz","002122.sz","002450.sz","002021.sz","300159.sz","002492.sz","002024.sz","002307.sz","002267.sz","002466.sz","002221.sz","002392.sz","002281.sz","002552.sz","300128.sz","002067.sz","300011.sz","300012.sz","002201.sz","002119.sz","002296.sz","300045.sz","002150.sz","002028.sz","002084.sz","300179.sz","002051.sz","002213.sz","002036.sz","002079.sz","002264.sz","002498.sz","300091.sz","002130.sz","002273.sz","300182.sz","002141.sz","300131.sz","000026.sz","002064.sz","300142.sz","002008.sz","300174.sz","002090.sz","002544.sz","002324.sz","002521.sz","002344.sz","002193.sz","002387.sz","300088.sz","002486.sz","002441.sz","002115.sz","002512.sz","300068.sz","002198.sz","002501.sz","002430.sz","002044.sz","300107.sz","300111.sz","002269.sz","002328.sz","300048.sz","002336.sz","300118.sz","002268.sz","002319.sz","300115.sz","002331.sz","002553.sz","002371.sz","002277.sz","300052.sz","002327.sz","002419.sz","002494.sz","002056.sz","300170.sz","002241.sz","002174.sz","000018.sz","002478.sz","002099.sz","002182.sz","002233.sz","002048.sz","002410.sz","300103.sz","002225.sz","002529.sz","002351.sz","300044.sz","002292.sz","002545.sz","300028.sz","002300.sz","002107.sz","002166.sz","300036.sz","002537.sz","002158.sz","002217.sz","300162.sz","300095.sz","002402.sz","002335.sz","300154.sz","002209.sz","002276.sz","002031.sz","300146.sz","002343.sz","300079.sz","002284.sz","300087.sz","300138.sz"};
        for (String data : codeList) {
            tool.getStockCurrentData(data.split("\\.")[0], data.split("\\.")[1]);
            try {
                // 当前线程等待1秒
                Thread.sleep(10L * 100L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        long end=System.currentTimeMillis();
//        System.out.println((end - start)/1000);//换算成秒钟 1s=1000ms

    }
}
