package iih.en.que.enqueue.d;

/**
 * 就诊队列状态
 * @author yankan
 * @since 2015-09-21
 *
 */
public interface EntQueStatus {
	public static final Integer NonArrival = -1;//未到诊
	public static final Integer Arrived = 0;//到诊
	public static final Integer Triaged = 1;//分诊
	public static final Integer Called = 2;//通知
	public static final Integer Accept = 3;//就诊
	public static final Integer AllArrival = 4;//全部到诊
	public static final Integer ReturnVisit = 5;//回诊
	public static final Integer CHECKEDFINISH = 8; //处置完成
	public static final String  NAME_NONARRIVAL = "挂号";
	public static final String  NAME_ARRIVED = "到诊";
	public static final String  NAME_TRIAGED = "侯诊";
	public static final String  NAME_ACCEPT = "就诊";
	public static final String  NAME_RETURNISIT = "回诊";
	public static final String  NAME_FG_TRIAGED = "候诊(回)";
	public static final String  NAME_DIAGNOSIS = "诊毕";
}
