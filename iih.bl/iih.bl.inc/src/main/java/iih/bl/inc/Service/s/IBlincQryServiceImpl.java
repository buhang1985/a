package iih.bl.inc.Service.s;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.incca.d.IncCaDO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.comm.IBlMsgConst;
import iih.bl.comm.util.BlInccaParamUtil;
import iih.bl.inc.blcpntpdto.d.BlCpnTpDto;
import iih.bl.inc.blinccanc.bp.BlinccancBp;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.blinciss.d.desc.BlIncIssDODesc;
import iih.bl.inc.blincquery.bp.BlIncQryBP;
import iih.bl.inc.blincquery.bp.BlincqueryBp;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlIncoepqueryDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceDetailsDTO;
import iih.bl.inc.blincquerydto.d.BlincQueryDTO;
import iih.bl.inc.blincquerydto.d.BlincitmIpDTO;
import iih.bl.inc.blincquerydto.d.DetailsReceiptDTO;
import iih.bl.inc.blincquerydto.d.OepInccaItmDTO;
import iih.bl.inc.bp.GetCpnInCodeBp;
import iih.bl.inc.ep.CpnInEp;
import iih.bl.inc.service.i.IBlincQryService;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;

import java.util.List;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;


/** 文件头注释
* ==============================================================================
* @Filename: IBlincQryServiceImpl   
* @Date: 2016/06/30 10:37:15
* @Compiler: Eclipse luna 4.4.1 
* @author li_pengying
* @Company: Copyright 2016 by PKU healthcare IT Co.,Ltd.
* @Description: 发票综合查询用接口实现类
* ==============================================================================
*/
	@Service(serviceInterfaces = {IBlincQryService.class }, binding = Binding.JSONRPC)
	public class IBlincQryServiceImpl implements IBlincQryService {
		
		@Override
		public  BlIncIssDO[]  getBlIncIssDoByStrIDinciss(String id_inciss) throws BizException
		{
			BlinccancBp bp=new BlinccancBp();
			return bp.getBlIncIssDoByStrIDinciss(id_inciss);
	    }
	
		@Override
		public   Boolean  isUsedByTableBIlinccanc(String incno,String id_incca,String id_codeincpkg,String id_grp,String id_org) throws BizException {
			BlinccancBp bp=new BlinccancBp();
			Boolean flag = bp.isUsedByTableBIlinccanc(incno, id_incca,id_codeincpkg,id_grp,id_org);
			return flag;
		}
		
		@Override
		public   Boolean  isUsedByTableBIlincip(String incno, String id_incca,String id_codeincpkg,String id_grp,String id_org) throws BizException {
			BlinccancBp bp=new BlinccancBp();
			return bp.isUsedByTableBIlincip(incno, id_incca,id_codeincpkg,id_grp,id_org);
		}
		
		@Override
		public    Boolean  isUsedByTableBIlincoep(String incno, String id_incca,String id_codeincpkg,String id_empiss,String id_grp,String id_org) throws BizException {
			BlinccancBp bp=new BlinccancBp();
			return bp.isUsedByTableBIlincoep(incno, id_incca,id_codeincpkg,id_empiss,id_grp,id_org);
		}
		
		@Override
		public BlIncIssDO[] getBlincissdoByCodeincpkg(String code_incpkg ,String id_incca)
				throws BizException {
			// TODO Auto-generated method stub
			BlinccancBp bp=new BlinccancBp();
			return bp.getBlincissdoByCodeincpkg(code_incpkg,id_incca);
		}
	

		@Override
		public String getInccaCancNameByIdincca(String Idincca) throws BizException {
			// TODO Auto-generated method stub
			BlinccancBp bp=new BlinccancBp();
			return bp.getInccaCancNameByIdincca(Idincca);
		}
		
		@Override
		public BlincQueryDTO[] findByIdincAndIdincca(String id_bilincdto,String id_incca) throws BizException {
			// TODO Auto-generated method stub
			BlincqueryBp  bp=new BlincqueryBp();
			return bp.findByIdincAndIdincca(id_bilincdto,id_incca);
		}
		
		@Override
		public BlIncoepqueryDTO[] findByIdincoep(String id_incoepdto) throws BizException {
			// TODO Auto-generated method stub
			BlincqueryBp  bp=new BlincqueryBp();
			return bp.findByIdincoep(id_incoepdto);
		}
		
		@Override
		public OepInccaItmDTO[]  findOepInccaItmDTOByIds1(String id_incoep,String id_incca)throws BizException{
			BlincqueryBp  bp=new BlincqueryBp();
			return  bp.findOepInccaItmDTOByIds(id_incoep,id_incca);
		}
		
		@Override
		public  OepInccaItmDTO[]  findOepInccaItmDTOByIds(String id_incoep,String id_incca,String id_incca2)throws BizException{
			BlincqueryBp  bp=new BlincqueryBp();
			return  bp.findOepInccaItmDTOByIds(id_incoep,id_incca,id_incca2);
		}
		
		@Override
		public DetailsReceiptDTO[] findDetailsReceiptDTOByIdsandIdorg(String id_incoep,String id_incca,String id_incca2,String id_org)throws BizException{
			BlincqueryBp  bp=new BlincqueryBp();
			return  bp.findDetailsReceiptDTOByIdsandIdorg(id_incoep,id_incca,id_incca2,id_org);
		}
		
		@Override
		public DetailsReceiptDTO[] findDetailsReceiptDTOByIdS(String id_incoep,
				String id_incca, String id_incca2) throws BizException {
			// TODO Auto-generated method stub
		   BlincqueryBp bp=new BlincqueryBp();
		   return bp.findDetailsReceiptDTOByIdS(id_incoep,id_incca,id_incca2);
		}
		
		@Override
		public BlIncoepqueryDTO[] findBlIncoepqueryDTOByIncno(String incno,String id_inc)
				throws BizException {
			// TODO Auto-generated method stub
			 BlincqueryBp bp=new BlincqueryBp();
			return bp.findBlIncoepqueryDTOByIncno(incno,id_inc) ;
		}
		
		/**
		 * 获得当前用户的票据包编号
		 * @param id_org 所属组织( 不用了)
		 * @param id_emp_iss 发票领用人员ID
		 * @param code_entp 就诊类型
		 * @return
		 * @throws BizException
		 */
		@Override
		public String getCodeIncPkgByIdempissAndCodeEntp(String id_org, String id_emp_iss,
				String code_entp) throws BizException 
		{
			String code_incca="";
			if (code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)
					|| code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)
					|| code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)) 
			{
				code_incca=IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE;
			}
			else
			{
				code_incca=IBdInccaCodeConst.CODE_INHOS_INVOICE;
			}
		
			StringBuffer sql=new StringBuffer();
			sql.append(" select id_incca from bd_incca where code='").append(code_incca).append("'");
			DAFacade dafacade=new DAFacade();
			List<IncCaDO> incCaDOLst=(List<IncCaDO>)dafacade.execQuery(sql.toString(), new BeanListHandler(IncCaDO.class));
			if(incCaDOLst==null || incCaDOLst.size()==0)
			{
				throw new BizException("没有找到对应的票据类型ID");
			}
			return getCodeIncPkgByIdempiss(id_org,id_emp_iss,incCaDOLst.toArray(new IncCaDO[0])[0].getId_incca());
		}
		
		/**
		 * 获得当前用户的票据包编号
		 * @param id_org 所属组织( 不用了)
		 * @param id_emp_iss 发票领用人员ID
		 * @param id_incca 票据类型
		 * @return
		 * @throws BizException
		 */
		@Override
		public String getCodeIncPkgByIdempiss(String id_org, String id_emp_iss,
				String id_incca) throws BizException {
			
			ColumnHandler handler = new ColumnHandler();
			StringBuffer sql=new StringBuffer();
			sql.append(" select x.code_incpkg ");
			sql.append("   from bl_inc_iss x ");
			sql.append("  where  ");
			
			String hostId = Context.get().getClientHost();
			String idPc = null;
			if(BlInccaParamUtil.isPc(id_incca)){
				idPc = BlParams.getRealPcId(hostId);
				sql.append("    x.id_pc = ? ");
			}else{
				sql.append("    x.id_emp_iss = ? ");
			}
			sql.append("    and x.fg_curuse = 'Y' ");
			sql.append("    and x.id_incca = ? and x.ds=0 ");
			SqlParam sqlParam = new SqlParam();
			//sqlParam.addParam(id_org);
			if(idPc == null){
				sqlParam.addParam(id_emp_iss);
			}else{
				sqlParam.addParam(idPc);
			}
			sqlParam.addParam(id_incca);
			DAFacade cade = new DAFacade();
			Object result=cade.execQuery(sql.toString(),sqlParam,handler);
			if(result==null)
			{    		
				throw new BizException("当前用户没有可用票据包");
			}
			return result.toString();
		}

		@Override
		public BlCpnTpDto[] findBlCpnTpList() throws BizException {
			CpnInEp ep = new CpnInEp();
			return  ep.getBlCpnTpList() ;
			
			//BlCpnIpDp blCpnIpDp = new BlCpnIpDp();
			//return blCpnIpDp.getBlCpnTpList();
		}

		@Override
		public String findBlCpnInCodeInfo() throws BizException {
			GetCpnInCodeBp  bp =new GetCpnInCodeBp();
			return bp.getBlCpnInCode();
			
		//	BlCpnIpDp blCpnIpDp = new BlCpnIpDp();
		//	return blCpnIpDp.getBlCpnInCode();
		}

//		/**
//		 * 发票查询
//		 */
//		@Override
//		public PagingRtnData<BlincQueryDTO> findByPageInfo(PaginationInfo pg,
//				String wherePart, String orderByPart) throws BizException {
//			 BlincqueryBp bp=new BlincqueryBp();
//				return bp.findByPageInfo(pg,wherePart,orderByPart) ;			
//		}

		/**
		 * 发票查询
		 * @author LIM
		 * @since 2019-10-21
		 */
		@Override
		public PagingRtnData<BlincQueryDTO> findByPageInfo(PaginationInfo pg,
				String incType, String wherePart) throws BizException {
			BlIncQryBP bp = new BlIncQryBP();
			return bp.findByPageInfo(pg, incType, wherePart);
			
		}
		/**
		 * 发票票据查询新
		 */
		@Override
		public PagingRtnData<BlincQueryDTO> incQryNew(PaginationInfo pg, String incType, String whereCondition)
				throws BizException {
			BlincqueryBp bp=new BlincqueryBp();
			return bp.incQryNew(pg,incType,whereCondition) ;
		}
		
		@Override
		public String getQueryConditions(String[] conds) throws BizException {
			// TODO Auto-generated method stub
			 BlincqueryBp bp=new BlincqueryBp();
				return bp.getQueryConditions(conds) ;
		}

		@Override
		public BlCgItmOepDO[] getOepInvoiceInfo(String id_incca, String id_inc)
				throws BizException {
			// TODO Auto-generated method stub
			 BlincqueryBp bp=new BlincqueryBp();
				return bp.getOepInvoiceInfo(id_incca, id_inc) ;
		}

		@Override
		public BlCgItmOepDO[] getOepInvoiceInfoGroupbyInccaitm(String id_incca, String id_inc) throws BizException{
			BlincqueryBp bp=new BlincqueryBp();
			return bp.getOepInvoiceInfoGroupbyInccaitm(id_incca, id_inc) ;
		}
		
		
		@Override
		public BlIncItmIpDO[] getIpInvoiceInfo(String id_incca, String id_inc)
				throws BizException {
			// TODO Auto-generated method stub
			BlincqueryBp bp=new BlincqueryBp();
			return bp.getIpInvoiceInfo(id_incca, id_inc) ;
		}

		@Override
		public BlCgItmOepDO[] getOepIncReceiptInfo(String id_incca,
				String id_inc) throws BizException {
			// TODO Auto-generated method stub
			BlincqueryBp bp=new BlincqueryBp();
			return bp.getOepIncReceiptInfo(id_incca, id_inc) ;
		}

		@Override
		public BlincitmIpDTO[] findIncItmIpDTOsByIncno(String id_incca,
				String id_incip) throws BizException {
			// TODO Auto-generated method stub
			BlincqueryBp bp=new BlincqueryBp();
			return bp.getIncItmIpDTOsByIncno(id_incca, id_incip) ;
		}

		@Override
		 public  String  getAuthorityByUserid(String userid ,String nodecode) throws BizException{
			BlincqueryBp bp=new BlincqueryBp();
			return bp.getAuthorityByUserid(userid, nodecode) ; 
		 }

		/**
		 * 通过门诊发票主键id_incoep获取到本张发票所对应的结算中所包含的所有收付款明细中的【付款方式】总和
		 */
		@Override
		public DetailsReceiptDTO[] findAllPaymodenamesByIdincoep(
				String id_incoep) throws BizException {
			// TODO Auto-generated method stub
			BlincqueryBp bp=new BlincqueryBp();
			return bp.findAllPaymodenamesByIdincoep(id_incoep) ; 
		}

		@Override
		public BlIncItmVsTypeDTO[] getSeveralAmtValuesByIdstoep(String id_incoep)
				throws BizException {
			// TODO Auto-generated method stub
			BlincqueryBp bp=new BlincqueryBp();
			return  bp.getSeveralAmtValuesByIdstoep(id_incoep);
		}

	  /**
	  * 通过患者的主键id_pat 和 门诊发票的主键id_incoep,id_incca 得到门诊患者的医保计划目录类型名称，即是甲乙丙哪个类别
      * @param id_incoep
      * @param id_pat
      * @param id_incca
      * @author li_pengying
      * @return
      * @throws BizException
		 */
		@Override
		public BlInvoiceDetailsDTO findHpnameByIdincoep(String id_incoep,
				String id_pat, String id_incca) throws BizException {
			// TODO Auto-generated method stub
			BlincqueryBp bp=new BlincqueryBp();
			return  bp.findHpnameByIdincoep(id_incoep,id_pat,id_incca);
	    }
		
		@Override
		public BlIncItmVsTypeDTO[] getIncOepInfoDto(String strIdInc,BlincQueryDTO blincqueryDTO)
				throws BizException {
			// TODO Auto-generated method stub
			BlincqueryBp bp=new BlincqueryBp();
			return bp.getIncOepInfoDto(strIdInc,blincqueryDTO);
		}

		

}
