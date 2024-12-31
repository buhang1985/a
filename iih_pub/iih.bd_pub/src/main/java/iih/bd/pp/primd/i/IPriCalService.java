package iih.bd.pp.primd.i;

import iih.bd.pp.dto.d.BdSrvPriceDTO;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.srv.dto.d.SrvSetItemDTO;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/**
* 价格计算服务操作接口方法服务
*/
public interface IPriCalService {

	 /**
     * 供CI折扣价调用（本服务定价模式批量接口）
     * 根据患者价格分类和服务数组（id_srv,Name_srv),返回服务相关信息（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）
     * @param pricalSrvDTO 待计价服务数组（id_srv,Name_srv)
     * @param id_pripat 患者价格分类
     * @return 服务相关信息（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）
     * @throws BizException 
     */
   public abstract SrvPricalRateAndPriceDTO[] CalManySrvsPriceMapByIdPripat_withoutThrow( PriStdSrvDTO[] pricalSrvDTO,String id_pripat )  throws BizException; 

/**
	 * 供CI折扣价调用(组合定价模式批量接口）
	 * 计算多个组合定价内容
	 * @param Id_srv_comparr 多个组合定价
	 * @param id_pripat 价格分类
	 * @return 返回Map<String,Map<String,SrvPricalRateAndPriceDTO>>格式的服务相关信息
	 *         <id_srv_comp组合定价ID,<id_srv,（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）>组合定价内容>
	 * @throws BizException
	 * @since 2017-5-17
	 */
	public abstract Map<String,Map<String,SrvPricalRateAndPriceDTO>> CalMultiSrvCompPriceByIdpripat_map(String[] Id_srv_comparr,String id_pripat)
			throws BizException ;

/**
	 * 供CI折扣价调用(服务套成员项目部位加收定价模式接口)
	 * 计算服务套成员项目部位个数加收（加收对应的加收服务ID，标准价格）
	 * @param Id_srv_set 服务套
	 * @param num 部位个数加收
	 * @param id_pripat 价格分类
	 * @return 返回Map<String,Map<String,SrvPricalRateAndPriceDTO>>格式的服务相关信息
	 *         <本服务ID或者组合定价ID,<id_srv,（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）>定价内容>
	 * @throws BizException
	 */
	public abstract Map<String,Map<String,SrvPricalRateAndPriceDTO>> CalSrvSetMUPricesByIdPripat_map(String Id_srv_set, int num,String id_pripat)
			throws BizException;

/**
	 * 供CI折扣价调用(服务套成员项目个数定价模式接口)
	 * 计算服务套成员项目个数定价（加收对应的加收服务ID，价格）
	 * @param Id_srv_set  服务套成员id
	 * @param num 数量
	 * @param id_pripat
	 * @return 返回Map<String,Map<String,SrvPricalRateAndPriceDTO>>格式的服务相关信息
	 *         <本服务ID或者组合定价ID,<id_srv,（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）>组织定价内容>
	 * @throws BizException
	 */	
	public abstract Map<String,Map<String,SrvPricalRateAndPriceDTO>>  CalSrvSetFIXPricesByIdPripat_map(String Id_srv_set, int num,String id_pripat)
			throws BizException;


/**
	 * 供CI折扣价调用(组合定价模式接口)
	 * @param Id_srv_comp  组合id
	 * @param id_pripat 价格分类
	 * @return 返回Map<String,Map<String,SrvPricalRateAndPriceDTO>>格式的服务相关信息
	 *         <本服务ID,<id_srv,（服务项目，价格系数，标准价格，折扣价格，数量，错误信息）>定价内容>
	 * @throws BizException
	 */	
	public abstract Map<String,SrvPricalRateAndPriceDTO> CalSrvCompPriceByIdPripat_map(String Id_srv_comp,String id_pripat)
			throws BizException ;
	
	
	/**
     * 计算多种价格分类下，指定服务的价格(CI调用）
     * @param pricalSrvDTO 待计价服务数组（id_srv,id_name)
     * @param id_pripats 价格分类
     * @return <
     * @throws BizException
     */
    public abstract Map<String,SrvPricalRateAndPriceDTO[]> CalManySrvsPriceMapByIdPripats( PriStdSrvDTO[] pricalSrvDTO,String[] id_pripats )  throws BizException; 

    /**
     * 供CI域调用，任务计划里使用，计算出标准服务在多种患者价格分类下的标准价格，以及对应的价格分类
     * @param pricalSrvDTO，只需要写ID_SRV,如果能确定QUAN,则写入QUAN
     * @return pricalSrvDTO (含id_pripat)
     * @throws BizException
     */
    public abstract Map<String,Map<String,Map<String,SrvPricalRateAndPriceDTO>>> calSrvPriUnderPripatsBatch(PriStdSrvDTO[] pricalSrvDTO) throws BizException;
	
    /**
  	 * 循环调用计算单个服务标准价格完成多服务标准计价
  	 * @param pricalSrvDTO 需要计算价格的服务数组
  	 * @return 返回价格
  	 */
   public abstract Map<String,FDouble> CalManySrvStdPriceMap( PriStdSrvDTO[] pricalSrvDTO )  throws BizException;

	/**
	 * 用bd_pri_srv中的价格同步bd_srv中的pri
	 * @param bdSrvPriceDTOArr 待同步的bd_srv的信息
	 * @return 需要同步的<id_srv,价格>
	 * @throws BizException
	 */
	public abstract Map<String,FDouble> bdsrvPriceSynchronization(BdSrvPriceDTO[] bdSrvPriceDTOArr)  throws BizException; 

	 /**
	 * 计价引擎，根据服务和定价模式，计算服务价格DTO
	 * @param srvId 服务ID
	 * @param primdId 定价模式ID
	 * @param strDateTime 提前价格的时间
	 * @return 返回价格DTO
	 */
    public abstract PriStdSrvDTO[] CalSrvStdPriceDTOEngine( String Id_srv,String id_primd,String strDateTime )  throws BizException;

	
	/**
	 * 计算多个服务标准价格
	 * @param pricalSrvDTO
	 * @return
	 * @throws BizException
	 */
	public abstract PriStdSrvDTO[] CalManySrvsStdPrices(PriStdSrvDTO[] pricalSrvDTO) throws BizException;
	/**
	 * 计算单个服务标准价格
	 * @param Id_srv	 
	 * @return
	 * @throws BizException
	 */
	public abstract FDouble CalSingleSrvStdPrice( String Id_srv )  throws BizException ;
	
	/**
	 * 计算单个服务标准价格,如果计算失败，则会提示：
	 * "该服务不存在或不存在当前价格。\r\n服务名称："+Name_srv+"。\r\n 服务ID: "+Id_srv
	 * @param Id_srv 服务ID
	 * @param Name_srv 服务名称
	 * @return
	 * @throws BizException
	 */
	public abstract FDouble CalSingleSrvStdPrice_NameTip( String Id_srv,String Name_srv )  throws BizException ;
	
	/**
	 * 在价格分类基础上计算单个服务价格,如果没有查询到结果，则会提示：
	 * "该服务不存在或不存在当前价格。\r\n服务名称："+Name_srv+"。\r\n 服务ID: "+Id_srv
	 * @param Id_srv  服务ID
	 * @param Name_srv 服务名称
	 * @param id_pripat 价格分类
	 * @return 返回指定价格分类下的所有特殊服务计价比例和价格DTO
	 */
    public abstract SrvPricalRateAndPriceDTO CalSingleSrvPriceByIdPripat_NameTip( String Id_srv,String Name_srv,String id_pripat )  throws BizException ;

    /**
     * 根据患者ID_ENT和服务数组（id_srv,id_name),返回服务相关信息（标准价格，价格比例，服务分类，服务分类或项目）
     * @param pricalSrvDTO 待计价服务数组（id_srv,id_name)
     * @param id_ent 患者ID_ENT
     * @return 服务相关信息（标准价格，价格比例，服务分类，服务分类或项目）
     * @throws BizException
     */
    public SrvPricalRateAndPriceDTO[] CalManySrvsPriceMapByIdent( PriStdSrvDTO[] pricalSrvDTO,String id_ent )  throws BizException;

   /**
    * 根据患者价格分类和服务数组（id_srv,id_name),返回服务相关信息（标准价格，价格比例，服务分类，服务分类或项目）
    * @param pricalSrvDTO 待计价服务数组（id_srv,id_name)
    * @param id_pripat 患者价格分类
    * @return 服务相关信息（标准价格，价格比例，服务分类，服务分类或项目）
    * @throws BizException
    */
   public abstract SrvPricalRateAndPriceDTO[] CalManySrvsPriceMapByIdPripat( PriStdSrvDTO[] pricalSrvDTO,String id_pripat )  throws BizException;

   
//	/**
//	 * 计算服务套成员项目部位个数加收（加收对应的部位加收服务ID，标准价格）
//	 * @param Id_srv_set 服务套ID，来源于bd_srv表
//	 * @param 加收的数量
//	 * @return 对应的部位加收服务ID，名称，标准价格
//	 * @throws BizException
//	 */
//	public abstract PriStdSrvDTO CalSrvSetMUPrice( String Id_srv_set,int num )  throws BizException ;
	
	/**
	 * 计算服务套成员项目个数定价（加收对应的加收服务ID，标准价格）
	 * @param Id_srv_set 服务套ID，来源于bd_srv表
	 * @param 加收的数量
	 * @return 对应的项目个数定价服务ID，名称，标准价格
	 * @throws BizException
	 */
	public abstract PriStdSrvDTO[] CalSrvSetFIXPrices( String Id_srv_set,int num )  throws BizException ;
	
	/**
	 * 计算服务套成员项目部位个数加收（加收对应的部位加收服务ID，标准价格）
	 * @param Id_srv_set 服务套ID，来源于bd_srv表
	 * @param 加收的数量
	 * @return 对应的部位加收服务ID，名称，标准价格
	 * @throws BizException
	 */
	public abstract PriStdSrvDTO[] CalSrvSetMUPrices( String Id_srv_set,int num )  throws BizException ;
	
//	/**
//	 * 计算服务套成员项目个数定价（加收对应的加收服务ID，标准价格）
//	 * @param Id_srv_set 服务套ID，来源于bd_srv表
//	 * @param 加收的数量
//	 * @return 对应的项目个数定价服务ID，名称，标准价格
//	 * @throws BizException
//	 */
//	public abstract PriStdSrvDTO CalSrvSetFIXPrice( String Id_srv_set,int num )  throws BizException ;
	
	/**
	 * 获得服务套内项目价格
	 * @param id_srv_set 服务ID
	 * @return SrvSetItemDTO[]
	 * @throws BizException
	 */
	public abstract SrvSetItemDTO[] getSrvSetItemDTO_price(String id_srv) throws BizException;

	
	/**
	 * 组合定价（加收对应的加收服务ID，标准价格）05
	 * @param Id_srv_comp 服务ID，来源于bd_srv表
	 * @return 对应的项目个数定价服务ID，名称，标准价格
	 * @throws BizException
	 */
	public abstract PriStdSrvDTO[] CalSrvCompPrice(String Id_srv_comp) throws BizException; 
	
	/**
	 * 组合定价（加收对应的加收服务ID，标准价格）05
	 * @param Id_srv_comp 服务ID，来源于bd_srv表
	 * @return 对应的项目个数定价服务ID，名称，标准价格
	 * @throws BizException
	 */
	public PriStdSrvDTO[] CalMultiSrvCompPrice(String[] Id_srv_comparr) throws BizException;
	
	/**
	 * 根据价格分类获得指定服务的价格比例
	 * @param id_srv 服务ID
	 * @param id_pripat 价格分类
	 * @return 服务计价比例DTO
	 * @throws BizException
	 */
	public abstract FDouble GetSingleSrvRateByIdPripat(String id_srv,String id_pripat)  throws BizException ;
	/**
	 * 获得指定价格分类下的所有特殊服务计价比例DTO（本接口没有计算服务价格）
	 * @param id_pripat
	 * @return
	 * @throws BizException
	 */
	public abstract SrvPricalRateAndPriceDTO[] GetAllSrvRatelByIdPripat(String id_pripat)  throws BizException ;
	
	/**
	 * 服务定价数据完整性校验：
	 * 服务的定价模式和定价数据匹配，是则完整，否则不完整
	 * @param id_srv 从费用角度检查服务ID是否定义完整
	 * @return 只返回不完整的服务  <id_srv,定义不完整的原因>
	 * @throws BizException
	 */
	public abstract FMap  integrityVerification_BdPriSrv(String[] id_srvArr) throws BizException;
	
	/**
	 * 服务定价数据清除：
	 * 清除该服务的指定定价模式的定价数据
	 * @param id_srv 服务ID
	 * @param id_primd 定价模式ID
	 * @return FBoolean.TRUE: 清除成功
	 */
	public abstract FBoolean clearBdSrvIdPrimd(String id_srv,String id_primd) throws BizException;
}
