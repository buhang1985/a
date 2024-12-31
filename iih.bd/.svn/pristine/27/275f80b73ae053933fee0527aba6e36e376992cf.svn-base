package iih.bd.pp.hp.bp;

import java.util.Arrays;
import java.util.List;

import iih.bd.pp.com.d.TreeDTO;
import iih.bd.pp.cust.d.CustDO;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.d.HpAggDO;
import iih.bd.pp.hp.s.HpCrudServiceImpl;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetHPTreeQryBp {

	//modified by yangyang 业务要求，以code为0001，0002，0003，0004起始的号码作为可用于医保计划的付款机构
	private final String SQL_CUST = "SELECT c.ID_CUST,c.CODE,c.NAME FROM BD_CUSTCA a INNER JOIN BD_CUST c ON a.ID_CUSTCA = c.ID_CUSTCA WHERE INSTR(A.SD_CUSTTP,'0001')>0 OR INSTR(A.Sd_Custtp,'0002')>0 OR INSTR(a.sd_custtp,'0003')>0 OR INSTR(a.sd_custtp,'0004')>0";

	private final String SQL_HP = "SELECT h.ID_HP,h.ID_CUST,h.CODE,h.NAME FROM BD_HP h";

	/**
	 * 获取医保计划树数据
	 * 
	 * @return
	 */
	public TreeDTO[] getTreeDTOList() throws BizException {
		CustDO[] custTreeCustDTO = this.getCustTreeDTO(SQL_CUST);

		if (custTreeCustDTO == null || custTreeCustDTO.length<=0) {
//			return null;
			throw new BizException("没有找到任意一个付款机构，请先维护付款机构!");
		}
		TreeDTO[] treeCust = this.TreeCustDTOToTreeDTO(custTreeCustDTO);
		HPDO[] hpTreeHPDTO = this.getHPTreeDTO(this
				.getHPQrySQL(custTreeCustDTO));
		if (hpTreeHPDTO == null) {
			return treeCust;
		} else {
			TreeDTO[] treeHp = this.TreeHPDTOToTreeDTO(hpTreeHPDTO);
			return this.concat(treeCust, treeHp);
		}
	}

	public Boolean deleteTreeDTO(TreeDTO treeDTO) throws BizException {
		boolean b = true;
		HpCrudServiceImpl service = new HpCrudServiceImpl();
		HpAggDO agg = service.findById(treeDTO.getId_obj());
		if (agg == null) {
			return false;
		}
		service.delete(new HpAggDO[] { agg });
		return b;
	}

	/**
	 * 得到医保计划中的一级树（Cust）
	 * 
	 * @param qry
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private CustDO[] getCustTreeDTO(String qry) throws BizException {
		List<CustDO> list = (List<CustDO>) new DAFacade().execQuery(qry,
				new BeanListHandler(CustDO.class));
		return list.toArray(new CustDO[0]);
	}

	@SuppressWarnings("unchecked")
	private HPDO[] getHPTreeDTO(String qry) throws BizException {
		List<HPDO> list = (List<HPDO>) new DAFacade().execQuery(qry,
				new BeanListHandler(HPDO.class));
		return list.toArray(new HPDO[0]);
	}

	private String getHPQrySQL(CustDO[] custTreeDTO) {
		String sql = SQL_HP + " WHERE ID_CUST IN (";
		int len = custTreeDTO.length;
		for (int i = 0; i < len - 1; i++) {
			sql += "'" + custTreeDTO[i].getId_cust() + "',";
		}
		sql += "'" + custTreeDTO[len - 1].getId_cust() + "')";
		return sql;
	}

	private TreeDTO[] TreeCustDTOToTreeDTO(CustDO[] hpTreeCustDTO) {
		TreeDTO[] dto = new TreeDTO[hpTreeCustDTO.length];
		for (int i = 0; i < hpTreeCustDTO.length; i++) {
			dto[i] = new TreeDTO();
			dto[i].setId_obj(hpTreeCustDTO[i].getId_cust());
			dto[i].setCode(hpTreeCustDTO[i].getCode());
			dto[i].setName(hpTreeCustDTO[i].getName());
			dto[i].setObjtype("CUST");
			dto[i].setId_par(null);
		}
		return dto;
	}

	private TreeDTO[] TreeHPDTOToTreeDTO(HPDO[] hpTreeHPDTO) {
		TreeDTO[] dto = new TreeDTO[hpTreeHPDTO.length];
		for (int i = 0; i < hpTreeHPDTO.length; i++) {
			dto[i] = new TreeDTO();
			dto[i].setId_obj(hpTreeHPDTO[i].getId_hp());
			dto[i].setCode(hpTreeHPDTO[i].getCode());
			dto[i].setName(hpTreeHPDTO[i].getName());
			dto[i].setObjtype("HP");
			dto[i].setId_par(hpTreeHPDTO[i].getId_cust());
		}
		return dto;
	}

	private <T> T[] concat(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
}
