package iih.bd.fc.s.bp.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import iih.mp.nr.i.IMpNrLogService;
import xap.mw.core.utils.StringUtil;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @Description:性能日志分析
 * @author: xu_xing@founder.com.cn
 * @version：2018年11月20日 上午9:41:48 创建
 */
public class LogUtils {

	private boolean fg_open;

	public LogUtils() {
		fg_open = true;
	}

	public LogUtils(boolean fg_open) {
		this.fg_open = fg_open;
	}

	/**
	 * 当前逻辑中各性能日志记录点的执行顺序
	 */
	private Integer Sornto = 1;
	private HashMap<Integer, String> mapTime = new HashMap<Integer, String>();

	/**
	 * 性能调优阶段日志
	 * 
	 * @param msg
	 */
	public void log(String msg) {
		if (!fg_open)
			return;
		IMpNrLogService logService = ServiceFinder.find(IMpNrLogService.class);
		String timeStr = getNow();
		if (Sornto > 1) {
			String consuming = "耗时：";
			SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			try {
				java.util.Date begin = dfs.parse(mapTime.get(Sornto - 1));
				java.util.Date end = dfs.parse(timeStr);
				long cost = end.getTime() - begin.getTime();
				consuming = consuming + cost;
				logService.log("步骤" + (Sornto - 1) + consuming, Level.INFO);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			logService.log("\r\n", Level.INFO);
		}
		logService.log(Sornto + "、" + msg + ":" + (getNow()), Level.INFO);
		mapTime.put(Sornto, timeStr);
		Sornto++;
	}

	/**
	 * 纯日志记录
	 * 
	 * @param msg
	 */
	public void logMsg(String msg) {
		if (StringUtil.isEmptyWithTrim(msg))
			return;
		ServiceFinder.find(IMpNrLogService.class).log(msg, Level.INFO);
	}

	/**
	 * 设置开始计算的锚点
	 */
	public void setPoint(String msg) {
		mapTime = new HashMap<Integer, String>();
		mapTime.put(1, getNow());
		ServiceFinder.find(IMpNrLogService.class).log("\r\n" + msg, Level.INFO);
	}

	/**
	 * 计算总体耗时
	 */
	public void setFinishLog() {
		try {
			String msg = "";
			String nowTimeStr = getNow();
			if (Sornto < 1) {
				msg = "********无法计算总体耗时！********";
			} else {
				try {
					SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
					java.util.Date begin = dfs.parse(mapTime.get(1));
					java.util.Date end = dfs.parse(nowTimeStr);
					long cost = end.getTime() - begin.getTime();
					msg = "★★★★★★★★总体耗时：【" + cost + "ms】★★★★★★★★\r\n";
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			ServiceFinder.find(IMpNrLogService.class).log(msg, Level.INFO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getNow() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		return format.format(date);
	}
}
