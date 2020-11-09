/**
 * Copyright(c) SUPCON 2008-2011. 浙江浙大中控信息技术有限公司
 */

package redis;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * 系统名称：智能交通WebService服务(ITSWebService)
 * 所属模块：系统初始化常量
 * 功能描述：系统初始化常量定义
 * 文件名：its.webservice.common.AppinitConstants.java
 * 版本信息：1.00
 * 
 * 开发部门：研发中心
 * 创建者： lzk
 * 创建时间：Feb 14, 2011 2:00:13 PM
 * 修改者： lzk
 * 修改时间：Feb 14, 2011 2:00:13 PM
 */

public class AppInitConstants {

	/**根据配置文件初始化是否预处理*/
	public  static Map<String, String> OSMDEVICEISCHECKSTATUS = new ConcurrentHashMap<String, String>();
	
	/** 卡口设备编号-密钥Map对 */
	public static Map<String, String> ALL_CODE_KEY_MAP;
	
	/** 所有路口编号-路口名Map对 */
	public static Map<String, String> ALL_CROSS_MAP;
	
	/**设备发屏参数*/
	public static Map<String, String> DEVICEINFO_LED_INFO;
	
	/** 前端保留过车图片的天数 */
    public static int GKJ_KEEP_IMG_DAYS = 1;
    
    /** 查询结果集，不得超过20000行 */
    public static int MAX_ROWCOUNT_RESULTLIST = 20000;
    
    /** 图片服务器前缀，用于统一保存过车图片 */
	public static String IMG_SERVER_FTP_PRE = "http://33.159.5.85/parastor/";
	
	/** 图片FTP服务器图片文件存放根目录 */
	public static String IMG_SERVER_FILE_PATH = "/wfpicserver1/";

	/** 图片上传保存绝对路径前缀 */
	public static String IMG_SERVER_ABS_FILE_PATH = "/parastor/";

	/** 电警webservice接口日志存放路径 */
	public static String log_FILE_PATH = "D:/osmfilelog/log";
	
	/** 卡口图片上传保存路径前缀 */
	public static String IMG_SERVER_ABS_FILE_PATH_KK = "/kk_pic";
	
	/** 违法图片上传保存路径前缀 */
	public static String IMG_SERVER_ABS_FILE_PATH_WF = "/wf_pic";
	/**提供给安吉合众同步用的临时文件夹，违法图片一式两份*/
	public static final String IMG_SERVER_ABS_FILE_PATH_WF_TEMP = "/wf_pic_temp";
	
	/** 视频违法抓拍图片上传保存路径前缀 */
	public static String IMG_SERVER_ABS_FILE_PATH_SP = "/sp_pic";
	
    /** 移动测速视频违法图片上传保存路径前缀*/
    public static String IMG_SERVER_ABS_FILE_PATH_XC = "/xc_pic";
	
	/** 系统部署地 */
	public static String DEPLOY_PLACE = "binjiang";
	
	/** 系统部署地 编号*/
	public static String DEPLOY_PLACE_NO = "330185";
	
    /** Socket代理服务器地址 */
    public static String SOCKET_PROXY_SERVER_IP = "172.16.183.146";
    
    /** 与Socket代理服务器通信端口 */
    public static int SOCKET_PROXY_SERVER_PORT = 12345;
    
	/** 方向字典类型ID */
	public static final String DIRECTION_TYPE_ID = "43";
	
	/**设备类型字典ID*/
	public static final String DEVICE_TYPE_ID = "77";
	
	/** 号牌种类字典类型ID */
	public static String CAR_TYPE_ID = "15";
	
	/** 布控类型字典类型ID */
	public static String BK_TYPE_ID = "78";
	
    /** 基础数据字典常量 */
    public static List DICTIONARY_LIST;
    
    /** 图片服务器保存电警图片数据天数 */
    public static int SERVER_KEEP_DJ_PIC_DAYS = 30;
    
    /** 图片服务器保存卡口过车图片天数 */
    public static int SERVER_KEEP_KK_PIC_DAYS = 60;
    
    /** 图片服务器保存视频违法图片天数 */
    public static int SERVER_KEEP_SP_PIC_DAYS = 30;
    
    /** 图片服务器保存 移动测速视频违法图片天数 */
    public static int SERVER_KEEP_XC_PIC_DAYS = 30;
    
    /** 是否具有布控报警功能,1有，0无 */
    public static String IS_NEED_BKBJ = "1";
    
    /** 集成平台同步命令端口 */
	public static int JCPT_COMMAND_PORT = 9898;

	/**  违法写入redis key*/
	public static String WF_REDIS_KEY="wfInfo";
    
    // 黑名单列表，号牌号码和号牌种类的缓存，浙FH1000_15
	public static Map<String, String> BLANKLIST = new HashMap<String, String>();
    

    
    public static ResourceBundle resource;
    
    /**  设备网络检测开关   0:关闭 1:开启  by LVHUA 2013-07-02 add */
    public static String NETWORK_OPEN = "1";
    
    /** 设备网络检测时间参数 单位:秒       by LVHUA 2013-07-03 add */  
    public static  int  TELNET_NETWORK_TIME = 3600 ;
    
    /** 定时初始化AppInitConstants定时器时间单位:秒       by LVHUA 2013-07-03 add */  
    public static  int  RE_APPINT_TIME = 600;
    
    /** 信产FTP地址 */
    public static String FTP_HOST_NAME_XC = "10.120.75.4";
    /** FTP用户名 */
    public static String FTP_USER_NAME = "supcon";
    /** FTP密码 */
    public static String FTP_USER_PASSWORD = "supcon";
    /** FTP端口 */
    public static String FTP_PORT = "21";
    /** FTP端口 */
    public static String FTP_ENCODING = "UTF-8";

	/**
	 * redis properties
	 */
	public static String channel="sub:isdcinfo";
	public static String host="127.0.0.1";
	public static int port=6379;
	public static int maxIdle=100;
	public static int maxActive=800;
	public static int maxWaitSeconds=3000;

    public static String WHITEVEHINFO="whiteinfo:baseinfo:";

	//日期间隔差
	public static int YESTERDAY=-1;
	//统计类型
	public static String TJLX="1";
	//有效期一个月
	public static int EXPIRE_SECOND=60*60*24*30;
	//redis key 违法前缀
	public static String KEY_PREFIX ="wf-";
	public static String LAST_TOTAL_FLAG="LAST_TOTAL_FLAG";

	//redis key 反向前缀
	public static String KEY_FX_PREFIX ="fx:";
}
