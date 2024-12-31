package iih.mm.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import xap.mw.core.utils.StringUtil;

public class MmFunLogUtil {

	private boolean fg_open = true;
	
	public MmFunLogUtil(boolean fg_open) {
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
		if (!this.fg_open) {
			return;
		}
		String timeStr = MmDateUtil.getNow();
		if (this.Sornto > 1) {
			String consuming = "耗时：";
			SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			try {
				java.util.Date begin = dfs.parse(this.mapTime.get(Sornto - 1));
				java.util.Date end = dfs.parse(timeStr);
				long cost = end.getTime() - begin.getTime();
				consuming = consuming + cost;
				MmLogUtil.getInstance().logInfo("步骤" + (Sornto - 1) + consuming);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			MmLogUtil.getInstance().logInfo("\r\n");
		}
		MmLogUtil.getInstance().logInfo(this.Sornto + "、" + msg + ":" + (MmDateUtil.getNow()));
		this.mapTime.put(this.Sornto, timeStr);
		this.Sornto++;
	}

	/**
	 * 纯日志记录
	 * 
	 * @param msg
	 */
	public void logMsg(String msg) {
		if (StringUtil.isEmptyWithTrim(msg))
			return;
		MmLogUtil.getInstance().logInfo(msg);
	}

	/**
	 * 设置开始计算的锚点
	 */
	public void setPoint() {
		this.mapTime = new HashMap<Integer, String>(); 
		this.mapTime.put(1, MmDateUtil.getNow());
		MmLogUtil.getInstance().logInfo("\r\n");
	}
	
	/**
	 * 计算总体耗时
	 */
	public void setFinishLog() {
		try {
			String msg = "";
			String nowTimeStr = MmDateUtil.getNow();
			if (this.Sornto < 1) {
				msg = "********无法计算总体耗时！********";
			} else {
				try {
					SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
					java.util.Date begin = dfs.parse(this.mapTime.get(1));
					java.util.Date end = dfs.parse(nowTimeStr);
					long cost = end.getTime() - begin.getTime();
					msg = "★★★★★★★★总体耗时：【" + cost + "ms】★★★★★★★★\r\n";
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			MmLogUtil.getInstance().logInfo(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
