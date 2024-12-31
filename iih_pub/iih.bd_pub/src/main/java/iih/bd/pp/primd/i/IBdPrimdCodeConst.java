package iih.bd.pp.primd.i;

/**
 * 定价模式编码
 * @author yankan
 * @since 2015-08-27
 *
 */
public interface IBdPrimdCodeConst {
	/**
	 * 定价模式编码
	 */
    public static final String CODE_PRI_SRV = "00"; //本服务定价
    public static final String CODE_PRI_SRVSET_AMOUNT = "01"; //服务套成员合计价
    public static final String CODE_PRI_SRVSET_MU = "02"; //服务套成员项目个数加收
    public static final String CODE_PRI_SRVSET_FIX = "03"; //服务套成员项目个数定价
    public static final String CODE_PRI_RES = "04"; //对应物品价格
    //public static final String CODE_PRI_SRV_PKG = "05"; //服务包成员合计价
    public static final String CODE_PRI_FREE="98";//不付费
    public static final String CODE_PRI_SRV_COMP = "05";//组合定价模式
    public static final String CODE_PRI_PLUGIN = "99"; //外挂价格定价插件
    
    
    
    /**
     * 定价模式ID
     */
    public static final String ID_PRI_SRV = "@@@@AA1000000000VBBQ"; //本服务定价
    public static final String ID_PRI_SRVSET_AMOUNT = "@@@@AA1000000000VBBR"; //服务套成员合计价
    public static final String ID_PRI_SRVSET_MU = "@@@@AA1000000000VBBV"; //服务套成员项目个数加收
    public static final String ID_PRI_SRVSET_FIX = "@@@@AA1000000000VBBW"; //服务套成员项目个数定价
    public static final String ID_PRI_RES = "@@@@AA1000000000VBBP"; //对应物品价格
    public static final String ID_PRI_FREE="@@@@AA1000000000VBBS";//不付费
    //public static final String ID_PRI_SRV_PKG = "0001AA1000000000VBBX"; //服务包成员合计价
    public static final String ID_PRI_SRV_COMP = "@@@@AA100000000815Q1";//组合定价模式
    public static final String ID_PRI_PLUGIN = "@@@@AA1000000006YX6I"; //外挂价格定价插件
}
