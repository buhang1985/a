package iih.bl.inc.service.i;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.inc.blcpntpdto.d.BlCpnTpDto;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlIncoepqueryDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceDetailsDTO;
import iih.bl.inc.blincquerydto.d.BlincQueryDTO;
import iih.bl.inc.blincquerydto.d.BlincitmIpDTO;
import iih.bl.inc.blincquerydto.d.DetailsReceiptDTO;
import iih.bl.inc.blincquerydto.d.OepInccaItmDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

/**
 * 发票综合查询节点用接口
 * @author li_pengying
 *
 */
public interface IBlincQryService {
	
	/**
	 * 通过发票领用表的主键获得发票所属的发票领用
	 * @param id_inciss
	 * @return
	 * @throws BizException
	 */
	public abstract  BlIncIssDO[]       getBlIncIssDoByStrIDinciss(String id_inciss) throws BizException;
	
	/**
	 * 通过发票的票据包编号得到其所属的发票领用
	 * @param code_incpkg
	 * @return
	 * @throws BizException
	 */
	public abstract  BlIncIssDO[]       getBlincissdoByCodeincpkg(String code_incpkg,String id_incca) throws BizException;
	
	
	/**
	 *  通过发票的号码来判断此发票是否已经被【空白发票作废表】所使用
	 * @param incno
	 * @param id_incca
	 * @param id_codeincpkg 票据包的主键id_inciss
	 * @author li_pengying
	 * @return
	 * @throws BizException
	 */
	public abstract  Boolean            isUsedByTableBIlinccanc(String incno, String id_incca,String id_codeincpkg,String id_grp,String id_org) throws BizException ;
	
	/**
	 * 通过发票的号码来判断此发票是否已经被【住院发票表】所使用
	 * @param incno
	 * @author li_pengying
	 * @param  id_incca
	 * @param  id_codeincpkg //票据包表的主键
	 * @return
	 * @throws BizException
	 */
	public abstract  Boolean            isUsedByTableBIlincip(String incno, String id_incca,String id_codeincpkg,String id_grp,String id_org) throws BizException ;
	
	/**
	 * 通过发票的号码来判断此发票是否已经被【门诊发票表】所使用
	 * @param incno  发票号码
	 * @param id_incca 票据类型
	 * @param id_codeincpkg 票据包表的主键
	 * @param id_emp_iss  票据包的领用人员主键即当前操作人的主键
	 * @return
	 * @throws BizException
	 */
	public abstract  Boolean   isUsedByTableBIlincoep(String incno, String id_incca,String id_codeincpkg,String id_emp_iss,String id_grp,String id_org) throws BizException ;
	
    
    /**
	*  根据分页信息及查询与分组条件获得分页数据
	*/
	public abstract PagingRtnData<BlincQueryDTO> findByPageInfo(PaginationInfo pg, String wherePart,String orderByPart) throws BizException;
	
    /**
     * 发票票据查询新
     * @param pg
     * @param wherePart
     * @param orderByPart
     * @return
     * @throws BizException
     */
	public abstract PagingRtnData<BlincQueryDTO> incQryNew(PaginationInfo pg, String incType,String whereCondition) throws BizException;
    
    /**
     * 通过发票的票据所属分类字段值得到发票的票据分类名称
     * @param Idincca
     * @return
     * @throws BizException
     */
    public abstract  String              getInccaCancNameByIdincca(String Idincca)throws BizException;
    
    /**
     *  通过门急诊住院综合发票的dto中的发票主键获得其对应的dto
     * @param id_bilincdto
     * @return
     * @throws BizException
     */
    public abstract  BlincQueryDTO[]     findByIdincAndIdincca(String id_blincdto,String id_incca)throws BizException;
    
    /**
     * 如果票据类型是门诊发票类型，通过发票的主键得到发票的记账明细信息，用于显示发票的表体的服务项目信息
     * @param id_incca
     * @param id_inc
     * @return
     * @throws BizException
     */
    public abstract  BlCgItmOepDO[]   getOepInvoiceInfo(String id_incca, String id_inc) throws BizException;
    
    /**
     * 对门诊发票类型，用于显示发票的表体的票据项目分类及其金额，即对查询出来的记账明细根据票据分类项目做分组处理，用于显示项目分类时发票表体显示
     * @param id_incca
     * @param id_inc
     * 
     * @author li_pengying
     * @return
     * @throws BizException
     */
    public abstract  BlCgItmOepDO[] getOepInvoiceInfoGroupbyInccaitm(String id_incca, String id_inc) throws BizException;
    
    /**
     * 得到门诊发票的小票表体显示使用数据源
     * @param id_incca
     * @param id_inc
     * @return
     * @throws BizException
     */
    public  abstract BlCgItmOepDO[] getOepIncReceiptInfo(String id_incca, String id_inc) throws BizException;
    
    /**
     * 如果票据类型是住院发票类型，通过发票的主键得到发票的记账明细信息，用于显示发票的表体的服务项目信息
     * @param id_incca
     * @param id_inc
     * @return
     * @throws BizException
     */
    public abstract  BlIncItmIpDO[]    getIpInvoiceInfo(String id_incca, String id_inc) throws BizException;
    
    
    public abstract  BlincitmIpDTO[] findIncItmIpDTOsByIncno(String id_incca, String id_incip)throws BizException;
    
   
    /**
     * 通过门急诊发票的dto中的发票主键获得其对应的dto
     * @param id_incoepdto
     * @return
     * @throws BizException
     */
    public abstract  BlIncoepqueryDTO[]  findByIdincoep(String id_incoepdto) throws BizException;
    
   
    /**
     * 
     * 通过门急诊发票的主键和其所属的票据分类来获得门急诊发票的服务所对应的服务分类名称
     * @param id_incoep
     * @param id_incca
     * @return
     * @throws BizException
     */
    public abstract  OepInccaItmDTO[]    findOepInccaItmDTOByIds1(String id_incoep,String id_incca)throws BizException;
    
    /**
     * 通过门急诊发票的主键和其所属的票据分类来获得门急诊发票的服务所对应的服务分类名称
     * @param id_incoep
     * @param id_incca
     * @param id_incca2
     * @return
     * @throws BizException
     */
    public abstract  OepInccaItmDTO[]    findOepInccaItmDTOByIds(String id_incoep,String id_incca,String id_incca2)throws BizException;
    
    /**
     * 通过门急诊发票的主键和其所属的票据分类字段值和当前登录的机构名称来获得门急诊发票的包含的费用明细，用于显示发票小条使用
     * @param id_incoep
     * @param id_incca
     * @param id_incca2
     * @param id_org
     * @return
     * @throws BizException
     */
    public abstract  DetailsReceiptDTO[] findDetailsReceiptDTOByIdsandIdorg(String id_incoep,String id_incca,String id_incca2,String id_org)throws BizException;
    
    /**
     * 通过门急诊发票的主键和其所属的票据分类字段值，来获得门急诊发票的包含的费用明细，用于显示发票小条使用
     * @param id_incoep
     * @param id_incca
     * @param id_incca2
     * @return
     * @throws BizException
     */
    public abstract  DetailsReceiptDTO[] findDetailsReceiptDTOByIdS(String id_incoep,String id_incca,String id_incca2)throws BizException;
    
    /**
     * 通过门急诊发票的发票主键id_inc和发票号码值，来获得门急诊发票的包含的费用明细，用于显示发票小条使用，因为不同的票据包里发票号可能一样所以还得加上发票主键id_inc这个查询条件
     * @param id_inc
     * @param incno
     * @return
     * @throws BizException
     */
    public abstract  BlIncoepqueryDTO[]  findBlIncoepqueryDTOByIncno(String incno,String id_inc) throws BizException;
    
    /**
     * 通过门诊发票主键id_incoep获取到本张发票所对应的结算中所包含的所有收付款明细中的【付款方式】总和
     * @param id_incoep
     * @return
     * @throws BizException
     */
    public abstract  DetailsReceiptDTO[]   findAllPaymodenamesByIdincoep(String id_incoep) throws BizException;
    
    
    public abstract  BlIncItmVsTypeDTO[]   getSeveralAmtValuesByIdstoep(String id_incoep) throws BizException;
    
    /**
     * 获得当前用户的票据包编号
     * @param id_org 所属组织
     * @param id_emp_iss 发票领用人员ID
     * @param id_incca 票据类型
     * @return
     * @throws BizException
     */
    public abstract  String  getCodeIncPkgByIdempiss(String id_org,String id_emp_iss,String id_incca)throws BizException;

    /**
	 * 获得当前用户的票据包编号
	 * @param id_org 所属组织( 不用了)
	 * @param id_emp_iss 发票领用人员ID
	 * @param code_entp 就诊类型代码
	 * @return
	 * @throws BizException
	 */	
	public abstract String getCodeIncPkgByIdempissAndCodeEntp(String id_org, String id_emp_iss,
			String code_entp) throws BizException; 
    
    /**
     * 获取优惠券类型和分类
     * */
    public abstract BlCpnTpDto[] findBlCpnTpList() throws BizException;
    
    /**
     * 获取优惠券入库单编码
     * */
    public abstract String findBlCpnInCodeInfo() throws BizException;
    
    
    /**
     * 
     * @param conds
     * @return
     * @throws BizException
     */
    public abstract String getQueryConditions(String[] conds) throws BizException;
    
    /**
     * 获得当前用户的权限,返回该用户权限的where条件
     * @param userid
     * @param nodecode
     * @author li_pengying
     * @return
     * @throws BizException
     */
     public abstract String  getAuthorityByUserid(String userid ,String nodecode) throws BizException;
     
     /**
      * 通过患者的主键id_pat 和 门诊发票的主键id_incoep,id_incca 得到门诊患者的医保计划目录类型名称，即是甲乙丙哪个类别
      * @param id_incoep
      * @param id_pat
      * @param id_incca
      * @author li_pengying
      * @return
      * @throws BizException
      */
     public abstract  BlInvoiceDetailsDTO findHpnameByIdincoep(String id_incoep,String id_pat,String id_incca)throws BizException;
     
     public abstract  BlIncItmVsTypeDTO[] getIncOepInfoDto(String strIdInc,BlincQueryDTO blincqueryDTO) throws BizException;
}
