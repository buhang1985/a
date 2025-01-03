package iih.bl.inc.bp;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.comm.IBlMsgConst;
import iih.bl.comm.util.BlInccaParamUtil;
//import sun.org.mozilla.javascript.internal.Context;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinccanc.i.IBlinccancCudService;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.bp.qry.IncIssOepInfoQry;
import iih.bl.inc.dto.d.BlIncissOepDTO;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 票据接口
 * @author tcy
 *
 */
public class BLInvoiceServiceBp {
	
	/**
	 * 新增空白作废票
	 * @param Id_emp_inc 用户ID
	 * @param code_incca 票据分类编码
	 * @param blIncCancDO
	 * @return
	 * @throws BizException
	 */
	public FBoolean AddBlIncCanc(String  Id_emp_inc,String code_incca,BlIncCancDO blIncCancDO)  throws BizException
	{
		//2.新增空白作废票
		if(blIncCancDO==null)
		{
			throw new BizException("新增空白作废票不能为空");
		}
		//1.校验该票号是否被作废
		if(validateCancInvoiceNo(blIncCancDO.getIncno(),code_incca))
		{
			throw new BizException("该票号已经被作废，不能再次作废！");
		}
		
		IBlinccancCudService iBlinccancCudService=ServiceFinder.find(IBlinccancCudService.class);
		BlIncCancDO[]  blIncCancDO1 =iBlinccancCudService.save(new BlIncCancDO[]{blIncCancDO});
		if(blIncCancDO1==null)
		{
			throw new BizException("保存空白作废票失败");
		}
		//3.检查即将打印的发票，是否需要后移
		String Curno=GetInvoiceNo(Id_emp_inc,code_incca);
		if(Curno.equals(blIncCancDO.getIncno()))
		{
			//hanjq:票据包过号修改为新接口的方式
			IBlIncUtilService blIncUtilService = ServiceFinder.find(IBlIncUtilService.class);
			blIncUtilService.nextInvoiceNo(Id_emp_inc, Context.get().getClientHost(), blIncCancDO.getId_incca());
			/*this.nextInvoiceNoUpdateCurNo(Id_emp_inc, code_incca);*/
		}
		
		return FBoolean.TRUE;
	}
	
	/**
	 * 删除空白作废票
	 * @param Id_emp_inc 用户ID
	 * @param code_incca 票据分类编码
	 * @param blIncCancDO
	 * @return
	 * @throws BizException
	 */
	public FBoolean DeleteBlIncCanc(String Id_emp_inc, String code_incca, BlIncCancDO blIncCancDO) throws BizException {
		// 1.作废空白作废票
		if (blIncCancDO == null) {
			throw new BizException("作废空白作废票不能为空");
		}
		IBlinccancCudService iBlinccancCudService=ServiceFinder.find(IBlinccancCudService.class);
		iBlinccancCudService.save(new BlIncCancDO[]{blIncCancDO});
		
		//2.检查即将打印的发票，是否需要前移
		this.nextInvoiceNoUpdateCurNo_minus1( blIncCancDO.getIncno(), code_incca, blIncCancDO.getCode_incpkg());
		
		
		return FBoolean.TRUE;
	}

	public String GetMaxInvoiceNo(String Id_emp_inc, String code_incca) throws BizException {
		ColumnHandler handler = new ColumnHandler();
		StringBuffer sbf=new StringBuffer();
		sbf.append("SELECT A.num_e");
		sbf.append(" FROM BL_INC_ISS A");
		sbf.append(" INNER JOIN BD_INCCA B ");
		sbf.append(" ON A.ID_INCCA = B.ID_INCCA ");
		sbf.append(" WHERE A.ID_EMP_ISS =  ?  AND ");
		sbf.append(" A.FG_CURUSE = 'Y' AND ");
		sbf.append(" B.CODE =  ?  and A.ds=0 ");
		//增加集团组织
		sbf.append(" and a.id_grp= ? and a.id_org= ? ");
		
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(Id_emp_inc);
		sqlparam.addParam(code_incca);
		sqlparam.addParam(Context.get().getGroupId());
		sqlparam.addParam(Context.get().getOrgId());
		
		DAFacade cade = new DAFacade();
		Object num_e = cade.execQuery(sbf.toString(), sqlparam, handler);
		if (num_e == null) {
			throw new BizException("获取当前票据结束号失败，请做以下操作：\r\n1.在<发票领退管理>界面，查询当前用户是否有可用票据。\r\n2.关闭本节点，再重新打开本节点");
		}
		
		return num_e.toString();
	}
	
	/**
	 * 获得当前可用票据号-增加啦计算机模式
	 * @param Id_emp_inc 用户ID
	 * @param code_incca 票据分类编码
	 * @return
	 * @throws BizException
	 */
	public String GetInvoiceNo(String Id_emp_inc,String code_incca) throws BizException{

		ColumnHandler handler = new ColumnHandler();
		StringBuffer sbf=new StringBuffer();
		SqlParam sqlparam = new SqlParam();
		sbf.append("SELECT A.INCNO_CUR");
		sbf.append(" FROM BL_INC_ISS A");
		sbf.append(" INNER JOIN BD_INCCA B ");
		sbf.append(" ON A.ID_INCCA = B.ID_INCCA ");
		
		String id_incca = BlInccaParamUtil.getIdIncca(code_incca);
		if(BlInccaParamUtil.isPc(id_incca)){
			String idPc = BlParams.getRealPcId(Context.get().getClientHost());
			sbf.append(" WHERE A.ID_PC = ? AND ");
			sqlparam.addParam(idPc);
		}else{
			sbf.append(" WHERE A.ID_EMP_ISS =  ? AND ");
			sqlparam.addParam(Id_emp_inc);
		}
		
		sbf.append(" A.FG_CURUSE = 'Y' AND ");
		sbf.append(" B.CODE = ? and A.ds=0 ");
		sqlparam.addParam(code_incca);
		//增加集团组织
		sbf.append(" and a.id_grp= ? and a.id_org= ? ");
		sqlparam.addParam(Context.get().getGroupId());
		sqlparam.addParam(Context.get().getOrgId());
		
		DAFacade cade = new DAFacade();
		String INCNO_CUR = (String)cade.execQuery(sbf.toString(),sqlparam , handler);
		if (StringUtils.isNullOrEmpty(INCNO_CUR)) {
			// 门诊发票11
			if (IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE.equals(code_incca)) {
				throw new BizException(IBlMsgConst.ERROR_INCISS_MZFP_ALERT);
			}
			//住院发票12
			if(IBdInccaCodeConst.CODE_INHOS_INVOICE.equals(code_incca)){
				throw new BizException(IBlMsgConst.ERROR_INCISS_ZYFP_ALERT);
			}
			//门诊押金条21
			if(IBdInccaCodeConst.CODE_OUTPATIENT_DEPOSIT.equals(code_incca)){
				throw new BizException(IBlMsgConst.ERROR_INCISS_MZYJT_ALERT);
			}
			//住院押金条22
			if(IBdInccaCodeConst.CODE_INHOS_DEPOSIT.equals(code_incca)){
				throw new BizException(IBlMsgConst.ERROR_INCISS_ZYYJT_ALERT);
			}
			//优惠套餐收据23
			if(IBdInccaCodeConst.CODE_DESIGNED_FUND.equals(code_incca)){
				throw new BizException(IBlMsgConst.ERROR_INCISS_ZYK_ALERT);
			}
			//门诊挂号发票
			if(IBdInccaCodeConst.CODE_OUTPATREGIST_INVOICE.equals(code_incca)){
				throw new BizException(IBlMsgConst.ERROR_INCISS_MZGHFP_ALERT);
			}
	     }
		
		return INCNO_CUR.toString();
	}
	
	/**
	 * 指定票据类型下，获取领取人当前可用的票据信息
	 * @param strIdEmpIss
	 * @param strCodeIncca
	 * @return
	 * @throws BizException
	 */
	public BlIncissOepDTO getIncissOepDtoByEmp(String strIdEmpIss, String strCodeIncca) throws BizException {
		BlIncissOepDTO[] incIssDtoLst = (BlIncissOepDTO[]) AppFwUtil.getDORstWithDao(new IncIssOepInfoQry(strIdEmpIss, strCodeIncca), BlIncissOepDTO.class);
		if (ArrayUtil.isEmpty(incIssDtoLst))
			throw new BizException("未查询到本人员的可使用票据，请先领用票据！");
		return incIssDtoLst[0];

	}
	
	/**
	 * 使用票据，并返回被使用的票据信息
	 * @param strIdEmp 票据领用人
	 * @param strCodeIncca 票据类型
	 * @return 票据领用信息
	 * @throws BizException
	 */
	public BlIncissOepDTO useReceipt(String strIdEmp, String strCodeIncca) throws BizException
	{
	    //获取当前可使用的票据信息
	    BlIncissOepDTO incIssOepdto=this.getIncissOepDtoByEmp(strIdEmp, strCodeIncca);
	    //使用后需要后移发票号
	    this.nextInvoiceNoUpdateCurNo(strIdEmp,strCodeIncca);
	    return incIssOepdto;
	}

	/**
	 * 检查票号是否是已作废的空白票
	 * @return已作废票：返回为TRUE;非作废票：返回False
	 */
	private boolean validateCancInvoiceNo(String invoiceNo,String strCodeIncca) throws BizException
	{
		//检查下一票是否属于已作废的废票
				ColumnHandler handler1 = new ColumnHandler();
		
				StringBuffer strWhere=new StringBuffer();
				strWhere.append(" SELECT B.INCNO FROM BL_INC_CANC B");
				strWhere.append(" INNER JOIN BL_INC_ISS A ON A.ID_GRP=B.ID_GRP AND A.ID_ORG=B.ID_ORG");
				strWhere.append(" INNER JOIN BD_INCCA C ON C.ID_INCCA=B.ID_INCCA");
				strWhere.append(" WHERE A.FG_CURUSE='Y' AND A.DS=0 AND A.FG_ACTIVE='Y'");
				strWhere.append(" AND C.CODE= ?");
				strWhere.append(" AND A.ID_ORG= ? ");
				strWhere.append(" AND A.ID_GRP= ? ");
				strWhere.append(" AND B.INCNO= ?");
				DAFacade cade = new DAFacade();
				SqlParam sqlP=new SqlParam();
				sqlP.addParam(strCodeIncca);
				sqlP.addParam(Context.get().getOrgId());
				sqlP.addParam(Context.get().getGroupId());
				sqlP.addParam(invoiceNo);
				Object id_incisso=cade.execQuery(strWhere.toString(),sqlP,handler1);
				if(id_incisso==null)
				{
					return false;  //未被作废
				}
				
				return true;  //被作废
				
				
	}
	/**
	 * 检查已作废的空白票是否属于当前票号
	 * @param incno 删除的作废空白票号
	 * @param code_incca 票据类型编码
	 * @return 若bl_inc_iss中当前票减1属于已作废的废票，返回票据类型ID；否则，返回“”
	 * @throws BizException
	 */
	private String validateCancInvoiceCurAdd1(String incno,String code_incca) throws BizException
	{
		//检查当前票减1是否属于已作废的废票
				ColumnHandler handler1 = new ColumnHandler();
				String checkSql=" select id_incca from bl_inc_iss "+
						        " where incno_cur= ?   AND "+
		                        " FG_CURUSE = 'Y' AND DS=0 "+
		                        " AND ID_INCCA ="+
								" (select x.id_incca from bd_incca x where x.code =  ? ) "+
								" and id_org= ?  and id_grp= ? ";
				SqlParam sqlparam = new SqlParam();
				sqlparam.addParam(incno);
				sqlparam.addParam(code_incca);
				sqlparam.addParam(Context.get().getOrgId());
				sqlparam.addParam(Context.get().getGroupId());
				DAFacade cade = new DAFacade();
				
				Object  id_incca = cade.execQuery(checkSql, sqlparam, handler1);
				if(id_incca!=null && !id_incca.toString().equals(""))
				{
					return id_incca.toString();
				}
				else
				{
					return "";
				}
	}
	
	/**
	 * 检查已作废的空白票是否属于当前票号-1
	 * @param incno 删除的作废空白票号
	 * @param code_incca 票据类型编码
	 * @return 若bl_inc_iss中当前票减1属于已作废的废票，返回票据类型ID；否则，返回“”
	 * @throws BizException
	 */
	private String validateCancInvoiceCurMinus1(String incno,String code_incca,String code_incpkg) throws BizException
	{
		//检查当前票减1是否属于已作废的废票
				ColumnHandler handler1 = new ColumnHandler();
				String checkSql=" select id_inciss from bl_inc_iss "+
						        /*" where incno_cur-1='"+incno+"'  AND "+*/
						        " where regexp_replace(incno_cur,'[0-9]*[a-z]+')-1=regexp_replace( ?  ,'[0-9]*[a-z]+')  AND "+
		                        " FG_CURUSE = 'Y'  AND ds=0 "+
		                        " AND ID_INCCA ="+
								" (select x.id_incca from bd_incca x where x.code =  ? ) "+
								" and id_org= ?  and id_grp= ? " +
								" and code_incpkg = ? ";

				SqlParam sqlparam = new SqlParam();
				sqlparam.addParam(incno);
				sqlparam.addParam(code_incca);
				sqlparam.addParam(Context.get().getOrgId());
				sqlparam.addParam(Context.get().getGroupId());
				sqlparam.addParam(code_incpkg);
				DAFacade cade = new DAFacade();
				Object  id_inciss = cade.execQuery(checkSql,sqlparam,handler1);
				if(id_inciss!=null && !id_inciss.toString().equals(""))
				{
					return id_inciss.toString();
				}
				else
				{
					return "";
				}
	}
	/**
     * 将指定票据号设置为当前票据号，仅供门诊结算使用，其他业务领域慎用
     * @param Id_emp_inc 操作员ID
     * @param id_incca 票据类型
     * @param invoiceNo  指定票据号
     * @throws BizException
     */	
	public void setCurNoByParamNo(String Id_emp_inc, String id_incca,
			String invoiceNo) throws BizException {
		//设置当前票号，如果已经超出票据包范围，则将该票据包的当前使用标志设为False
		setCheckCurNoIsEnd(Id_emp_inc,id_incca,invoiceNo);
		String code_incca="";

		ColumnHandler handler = new ColumnHandler();
		StringBuffer sbf=new StringBuffer();
		sbf.append("    select x.code from bd_incca x where x.id_incca =  ? ");
	//	sbf.append(" and x.id_org='"+Context.get().getOrgId()+"' and x.id_grp='"+Context.get().getGroupId()+"'");
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(id_incca);
		
		DAFacade cade0 = new DAFacade();
		code_incca=(String)cade0.execQuery(sbf.toString(),sqlparam,handler);
		//检查当前可用票号是否是已作废发票
		if(validateCancInvoiceNo(invoiceNo,code_incca))
		{			
			nextInvoiceNoUpdateCurNo(Id_emp_inc, code_incca);
		}
		
	}
	/**
	 * 设置当前票号，如果已经超出票据包范围，则将该票据包的当前使用标志设为False
	 * @param Id_emp_inc 发票领用人员
	 * @param id_incca 票据类型ID
	 * @param SetCurNo 设置的当前票号
	 * @throws BizException
	 */
	private void setCheckCurNoIsEnd(String Id_emp_inc, String id_incca,String SetCurNo) throws BizException 
	{
		StringBuffer sbf=new StringBuffer();
		int row=0;
//		sbf.append(" Update BL_INC_ISS ");
//		sbf.append("    set INCNO_CUR = '"+SetCurNo+"',inccn_use =inccn_use-1 ");		
//		sbf.append("    WHERE ID_EMP_ISS = '"+Id_emp_inc+"'");
//		sbf.append("    AND BL_INC_ISS.ID_INCCA ='"+id_incca+"'");		
//		sbf.append("    AND FG_CURUSE = 'Y'");
//		sbf.append("     and  Num_e>=INCNO_CUR + 1");//不超过该票据包的票据终止号
//		sbf.append(" and id_org='"+Context.get().getOrgId()+"' and id_grp='"+Context.get().getGroupId()+"'");
		
		
		sbf.append(" Update BL_INC_ISS set INCNO_CUR = ?,inccn_use =inccn_use-1 WHERE ID_EMP_ISS = ? AND BL_INC_ISS.ID_INCCA =? AND FG_CURUSE = 'Y'"
				+ " and  Num_e>=INCNO_CUR + 1 and id_org=? and id_grp=?");
		SqlParam param=new SqlParam();
	     param.addParam(SetCurNo);
	     param.addParam(Id_emp_inc);
	     param.addParam(id_incca);
	     param.addParam(Context.get().getOrgId());
	     param.addParam(Context.get().getGroupId());

		DAFacade cade = new DAFacade();
		row=cade.execUpdate(sbf.toString(),param);
		
		if(row==0)
		{
			//更改当前票据包，变为不可用状态
			StringBuffer sbfx=new StringBuffer();
//			sbfx.append(" Update BL_INC_ISS ");
//			sbfx.append("    set FG_CURUSE = 'N'");
//			sbfx.append("    WHERE ID_EMP_ISS = '"+Id_emp_inc+"'");
//			sbfx.append("    AND BL_INC_ISS.ID_INCCA ='"+id_incca+"'");
//			sbfx.append(" and id_org='"+Context.get().getOrgId()+"' and id_grp='"+Context.get().getGroupId()+"'");

			
			sbfx.append(" Update BL_INC_ISS set FG_CURUSE = 'N' WHERE ID_EMP_ISS = ? AND BL_INC_ISS.ID_INCCA = ?and id_org= ? and id_grp= ?");
			SqlParam param1=new SqlParam();
		     param1.addParam(Id_emp_inc);
		     param1.addParam(id_incca);
		     param1.addParam(Context.get().getOrgId());
		     param1.addParam(Context.get().getGroupId());
			DAFacade cadex = new DAFacade();
			row=cadex.execUpdate(sbfx.toString(),param);
		//	throw new BizException("该票据包内票据已使用完毕，请重新分发票据！");
		}
	}
	/**
	 * 用下一票号代替当前号 
	 * @param Id_emp_inc 用户ID
	 * @param code_incca 票据分类编码
	 * @throws BizException
	 */
	public void nextInvoiceNoUpdateCurNo(String Id_emp_inc, String code_incca) throws BizException {
			
		//1.获得当前票
		String curNo=this.GetInvoiceNo(Id_emp_inc, code_incca);		
		//2.获得下个票号
		GetCodeByCustomization getCodeByCustomization=new GetCodeByCustomization();
		String nextInvoiceNo=getCodeByCustomization.computeNextInvoiceNo(curNo);
		//3.检查下个票号是否被作废，若作废，则计算下个票号
		while(validateCancInvoiceNo(nextInvoiceNo,code_incca)) //被作废
		{
			nextInvoiceNo=getCodeByCustomization.computeNextInvoiceNo(nextInvoiceNo);
		}
		//4.更新当前票
		StringBuffer sbf=new StringBuffer();
		SqlParam sqlparam = new SqlParam();
		
		int row=0;
		
		char[] chars=nextInvoiceNo.toCharArray();	
		boolean hasLetter=false;
		//检查是否包含字母
		for(char char1: chars)
		{
			if(!(((int)char1)>=48 && ((int)char1)<=57)) //判断ASC码
			{
				hasLetter=true;
				break;
			}
		}		
		
		sbf.append(" Update BL_INC_ISS ");
		//sbf.append("    set INCNO_CUR = INCNO_CUR + 1");
		sbf.append("    set INCNO_CUR = ? ,inccn_use=inccn_use-1");//支持001的下张票号是002的情况
		sbf.append("    WHERE ID_EMP_ISS = ? ");
		sbf.append("    AND BL_INC_ISS.ID_INCCA =");
		sbf.append("    (select x.id_incca from bd_incca x where x.ds = 0 and x.code = ? )");
		sbf.append("    AND FG_CURUSE = 'Y'");
		sqlparam.addParam(nextInvoiceNo);
		sqlparam.addParam(Id_emp_inc);
		sqlparam.addParam(code_incca);

		if(hasLetter)//按字母ASC比较
		{
			sbf.append("     and  Num_e>= ? ");//不超过该票据包的票据终止号
			sqlparam.addParam(nextInvoiceNo);
		}
		else//按数字比较
		{
			sbf.append("     and  Num_e>= ? ");//不超过该票据包的票据终止号(数字比较也是按字母ASC比较)
			sqlparam.addParam(nextInvoiceNo);
		}
		sbf.append("  and id_org= ? and id_grp= ? ");
		sqlparam.addParam(Context.get().getOrgId());
		sqlparam.addParam(Context.get().getGroupId());
		
		DAFacade cade = new DAFacade();
		row=cade.execUpdate(sbf.toString(),sqlparam);
		
		
		
		if(row==0)
		{
			//更改当前票据包，变为不可用状态
			StringBuffer sbfx=new StringBuffer();
//			sbfx.append(" Update BL_INC_ISS ");
//			sbfx.append("    set FG_CURUSE = 'N'  , Incno_cur='0',inccn_use=inccn_use-1  ");
//			sbfx.append("    WHERE ID_EMP_ISS = '"+Id_emp_inc+"'");
//			sbfx.append("    AND BL_INC_ISS.ID_INCCA =");
//			sbfx.append("    (select x.id_incca from bd_incca x where x.code = '"+code_incca+"')");
//			sbfx.append("    AND FG_CURUSE = 'Y'");
//			sbfx.append("    and id_org='"+Context.get().getOrgId()+"' and id_grp='"+Context.get().getGroupId()+"'");
//			

			sbfx.append("Update BL_INC_ISS set FG_CURUSE = 'N'  , Incno_cur='0',inccn_use=inccn_use-1 WHERE ID_EMP_ISS = ? "
					+ "AND BL_INC_ISS.ID_INCCA =(select x.id_incca from bd_incca x where x.code = ?) AND FG_CURUSE = 'Y'"
					+"and id_org=? and id_grp= ?");
			SqlParam param=new SqlParam();
		     param.addParam(Id_emp_inc);
		     param.addParam(code_incca);
		     param.addParam(Context.get().getOrgId());
		     param.addParam(Context.get().getGroupId());
			DAFacade cadex = new DAFacade();
			row=cade.execUpdate(sbfx.toString(),param);
		//	throw new BizException("该票据包内票据已使用完毕，请重新分发票据！");
		}
//		//检查当前可用票号是否是已作废发票
//		if(ValidateCancInvoice())
//		{
	//		//将下一张票作为当前票号
//			NextInvoiceNoUpdateCurNo(Id_emp_inc, code_incca);
//		}
	}
	
	/**
	 * 用上一票号代替当前号，供【作废票据号】使用
	 * @param incno  空白发票号
	 * @param code_incca 票据类型
	 * @param code_incpkg 票据包编号
	 * @throws BizException
	 */
	public void nextInvoiceNoUpdateCurNo_minus1( String incno,String code_incca,String code_incpkg) throws BizException {
		//检查：删除的【作废票据号】等于对应票据包的【下次使用票据号】减1
		String id_inciss="";
		id_inciss=validateCancInvoiceCurMinus1(incno,code_incca,code_incpkg);
		//2.获得上个票号
		GetCodeByCustomization getCodeByCustomization=new GetCodeByCustomization();
		String presInvoiceNo=getCodeByCustomization.computePreviousInvoiceNo(incno);
		if(!id_inciss.equals(""))
		{
			StringBuffer sbf=new StringBuffer();		
//			sbf.append(" Update BL_INC_ISS ");
//			//sbf.append("    set INCNO_CUR = INCNO_CUR - 1");
//			sbf.append("    set INCNO_CUR = '"+presInvoiceNo+"',inccn_use=inccn_use+1");
//			//sbf.append("    WHERE ID_EMP_ISS = '"+Id_emp_inc+"'");
//			sbf.append(" where ");
//			sbf.append("    id_inciss ='"+id_inciss+"'");	
//			sbf.append(" and  id_org='"+Context.get().getOrgId()+"' and  id_grp='"+Context.get().getGroupId()+"'");
//
//			sbf.append("    AND FG_CURUSE = 'Y'");
			
			
			sbf.append("update BL_INC_ISS set INCNO_CUR = ? ,inccn_use=inccn_use+1 where id_inciss=? and id_org= ? and id_grp=? AND FG_CURUSE = 'Y'");
			SqlParam param=new SqlParam();
		     param.addParam(presInvoiceNo);
		     param.addParam(id_inciss);
		     param.addParam(Context.get().getOrgId());
		     param.addParam(Context.get().getGroupId());
			DAFacade cade = new DAFacade();
			cade.execUpdate(sbf.toString(),param);
			//检查当前可用票号是否是已作废发票
			if(validateCancInvoiceNo(incno,code_incca))
			{
				//将上一票号代替当前号，供删除的【作废票据号】使用
				nextInvoiceNoUpdateCurNo_minus1(incno,code_incca,code_incpkg);
			}
		}
	}
	
	/**
	 * 用下一票号代替当前号，供【作废票据号】使用
	 * @param incno  空白发票号
	 * @param code_incca 票据类型
	 * @param code_incpkg 票据包编号
	 * @throws BizException
	 */
	public void nextInvoiceNoUpdateCurNo_add1( String incno,String code_incca,String code_incpkg) throws BizException {
		//检查：删除的【作废票据号】等于对应票据包的【下次使用票据号】加1
		String id_incca="";
		id_incca=validateCancInvoiceCurAdd1(incno,code_incca);	
		//1.获得下个票号
		GetCodeByCustomization getCodeByCustomization=new GetCodeByCustomization();
		String nextInvoiceNo=getCodeByCustomization.computeNextInvoiceNo(incno);
		if(!id_incca.equals(""))
		{
			StringBuffer sbf=new StringBuffer();		
//			sbf.append(" Update BL_INC_ISS ");
//			//sbf.append("    set INCNO_CUR = INCNO_CUR + 1");
//			sbf.append("    set INCNO_CUR = "+nextInvoiceNo+",inccn_use=inccn_use-1");
//			//sbf.append("    WHERE ID_EMP_ISS = '"+Id_emp_inc+"'");
//			sbf.append(" where ");
//			sbf.append("    ID_INCCA ='"+id_incca+"'");	
//			sbf.append("    AND code_incpkg ='"+code_incpkg+"'");
//			sbf.append("    AND FG_CURUSE = 'Y' ");
//			sbf.append("  and  id_org='"+Context.get().getOrgId()+"' and  id_grp='"+Context.get().getGroupId()+"'");
			
			sbf.append(" Update BL_INC_ISS set INCNO_CUR = ? ,inccn_use=inccn_use-1 where ID_INCCA = ?  AND code_incpkg = ? AND FG_CURUSE = 'Y' and  id_org= ? and  id_grp= ?");
			SqlParam param=new SqlParam();
		     param.addParam(nextInvoiceNo);
		     param.addParam(id_incca);
		     param.addParam(code_incpkg);
		     param.addParam(Context.get().getOrgId());
		     param.addParam(Context.get().getGroupId());

			DAFacade cade = new DAFacade();
			cade.execUpdate(sbf.toString(),param);
			
		}
	}
	/**
	 * 获得指定票据包中当前可以使用的  若干张票据号
	 */
	public String[] getManyInvoiceNo(String Id_emp_inc, String code_incca,int  num,String code_incpkg) throws BizException {
		String[] invoiceNos=new String[num];
		invoiceNos[0]=GetInvoiceNo(Id_emp_inc, code_incca);//当前号码
		if(num>1)
		{
			for(int i=1;i<num;i++) 
			{
				//invoiceNos[i]=intinvoiceNos[0].valueOf(i)
				invoiceNos[i]=getInvoiceAdd1(invoiceNos[i-1]);
				//验证是否是废票
				while(validateCancInvoiceNo(invoiceNos[i],code_incca))
				{	
					invoiceNos[i]=getInvoiceAdd1(invoiceNos[i]);
					//验证是否超出票据包的开票范围
					if(getLastInvoiceInPackage(Id_emp_inc,code_incca,invoiceNos[i],code_incpkg).booleanValue())
					{
						if(i<num-1)
						{
							throw new BizException("发票数量不足，请分开结算，然后重新分配票据！");
						}
					}
				}
				
				
			}
		}
		return invoiceNos;
	}
	
	private String getInvoiceAdd1(String invoiceNo)
	{
		//return invoiceNo.substring(0,String.valueOf(Long.parseLong(invoiceNo)).length())+String.valueOf(Long.parseLong(invoiceNo)+1);
		GetCodeByCustomization getCodeByCustomization=new GetCodeByCustomization();
		//return String.valueOf(Long.parseLong(invoiceNo)+1);
		return getCodeByCustomization.computeNextInvoiceNo(invoiceNo);		
	}
	private String getInvoiceMinus1(String invoiceNo)
	{
		//return invoiceNo.substring(0,String.valueOf(Long.parseLong(invoiceNo)).length())+String.valueOf(Long.parseLong(invoiceNo)-1);
		//return String.valueOf(Long.parseLong(invoiceNo)-1);
		GetCodeByCustomization getCodeByCustomization=new GetCodeByCustomization();		
		return getCodeByCustomization.computePreviousInvoiceNo(invoiceNo);	
	}
	/**
	 * 判断当前票号是否在指定票据包里，如果是最后一张，返回为真，否则返回假
	 * @param Id_emp_inc
	 * @param code_incca
	 * @param invoiceNo
	 * @return
	 * @throws BizException
	 */
	private FBoolean getLastInvoiceInPackage(String Id_emp_inc, String code_incca,String invoiceNo,String code_incpkg) throws BizException
	{
		ColumnHandler handler = new ColumnHandler();
		StringBuffer sbf=new StringBuffer();
		sbf.append("SELECT A.id_inciss ");
		sbf.append(" FROM BL_INC_ISS A");		
		sbf.append(" WHERE A.ID_EMP_ISS = ?  ");
		sbf.append("    AND code_incpkg = ? ");
		sbf.append("    AND A.ID_INCCA =");
		sbf.append("    (select x.id_incca from bd_incca x where x.code = ? )");
		sbf.append("  and A.FG_CURUSE = 'Y' AND a.ds=0 and ");
		sbf.append("  A. Num_e< ? ");  //发票超出票据包范围
		sbf.append("  and a.id_org= ? and a.id_grp= ? ");

		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(Id_emp_inc);
		sqlparam.addParam(code_incpkg);
		sqlparam.addParam(code_incca);
		sqlparam.addParam(invoiceNo);
		sqlparam.addParam(Context.get().getOrgId());
		sqlparam.addParam(Context.get().getGroupId());
		
		DAFacade cade = new DAFacade();
		Object  INCNO_CUR = cade.execQuery(sbf.toString(), sqlparam, handler);
		if(INCNO_CUR==null)
		{
			return FBoolean.FALSE;  //票据在票据包范围内
		}
		return FBoolean.TRUE;  //票据不在票据包范围内
	}
	
	/**
	 * 判断是否是当前票号上一张票号
	 * @param id_emp_inc 票据开立人
	 * @param curNo 当前票号
	 * @param pre_no 待验证的上一票号
	 * @param code_incca 发票类型代码
	 * @param code_incpkg 票据包
	 * @return
	 * @throws BizException
	 */
	public FBoolean checkNoIsThePreviousOfCurno(String id_emp_inc,String curNo,String pre_no,String code_incca,String code_incpkg) throws BizException
	{
		FBoolean checkResult=FBoolean.FALSE;
		//1.获取当前票号
		if(curNo==null || curNo.trim().length()==0)
		{
			curNo=this.GetInvoiceNo(id_emp_inc, code_incca);
		}
		//
		//2.获得当前票号上一张号码
		StringBuffer sbf=new StringBuffer();		
		sbf.append(" select incno_cur,incno_cur-1 pre_no,NUM_B,NUM_E from bl_inc_iss ");
		sbf.append("    where ");
		sbf.append("    ID_INCCA =(select id_incca from bd_incca where code=?)");		
		sbf.append("    AND incno_cur-1 = ? ");
		sbf.append("    AND incno_cur = ? ");
		sbf.append("    AND code_incpkg =? ");
		sbf.append("  and  id_org= ?  and  id_grp= ? and ds=0");
		DAFacade cade = new DAFacade();
		//cade.execUpdate(sbf.toString());
		SqlParam sqlp=new SqlParam();
		sqlp.addParam(code_incca);
		sqlp.addParam(pre_no);
		sqlp.addParam(curNo);
		sqlp.addParam(code_incpkg);
		sqlp.addParam(Context.get().getOrgId());
		sqlp.addParam(Context.get().getGroupId());
		List<BlIncIssDO> BlIncIssDOList=(List<BlIncIssDO>)cade.execQuery(sbf.toString(), sqlp, new BeanListHandler(BlIncIssDO.class));
		if(BlIncIssDOList==null || BlIncIssDOList.size()==0)
		{
			//当前票号是前票据包的第一个号，则检查则上一个票号是这个收款员某个票据包的末尾
			StringBuffer sbf1=new StringBuffer();	
			sbf1.append(" select * from bl_inc_iss x ");
			sbf1.append("    where ");
			sbf1.append("    ID_INCCA =(select id_incca from bd_incca where code=?)");		
			sbf1.append("    AND NUM_E = ? ");
			sbf1.append("    AND id_emp_iss = ? ");
			sbf1.append("  and  id_org= ?  and  id_grp= ?  and ds=0");
			
			//cade.execUpdate(sbf.toString());
			SqlParam sqlp1=new SqlParam();
			sqlp1.addParam(code_incca);
			sqlp.addParam(pre_no);
			sqlp.addParam(id_emp_inc);
			sqlp.addParam(code_incpkg);
			sqlp.addParam(Context.get().getOrgId());
			sqlp.addParam(Context.get().getGroupId());
			List<BlIncIssDO> BlIncIssDOLst=(List<BlIncIssDO>)cade.execQuery(sbf.toString(), sqlp, new BeanListHandler(BlIncIssDO.class));
			if(BlIncIssDOLst==null || BlIncIssDOLst.size()==0)
			{
				checkResult=FBoolean.FALSE;
			}
		}
		else //本票据包内上一个号
		{
			checkResult=FBoolean.TRUE;
		}
		
			
		return checkResult;
		
	}
}
