package iih.pi.card.s.bp.cardmanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mysql.fabric.xmlrpc.base.Array;

import iih.bd.base.utils.SqlUtils;
import iih.mp.nr.dto.temporarytable.d.TamTableColumnDTO;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.i.ICardCudService;
import iih.pi.card.util.CreateTemTable;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.dic.cardtype.i.ICardtypeRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FType;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.securityfw.login.d.PasswordUtil;

/**
 * 卡批量导入
 * @author wq.li 2019年4月15日
 *
 */
public class ImportPiCardInfoBP {

	/**
	 * 卡批量导入
	 * @param cardDoS
	 * @throws BizException 
	 */
	public void exec(PiCardDO[] cardDoS) throws BizException{
		
		if(ArrayUtil.isEmpty(cardDoS)){
			return;
		}
		
		//校验数据重复
		this.dataCheck(cardDoS);
		
		//插入数据
		this.insertDO(cardDoS);
	}
	
	/**
	 * 校验数据是否重复
	 * @param cardDoS
	 * @throws BizException
	 */
	private void dataCheck(PiCardDO[] cardDoS) throws BizException{
		//创建中间表
		String tableName = this.createTable(cardDoS);
		
		//联合查询，校验重复卡号
		StringBuilder sql=new StringBuilder();
		sql.append(" select a0.code ");
		sql.append(" from  ");
		sql.append(tableName);
		sql.append(" a0 ");
		sql.append(" inner join pi_card card on card.code=a0.code ");
		
		List<PiCardDO> repeatDoList=(List<PiCardDO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(PiCardDO.class));
		
		if(!ListUtil.isEmpty(repeatDoList)){
			StringBuilder msg=new StringBuilder();
			msg.append("导入数据与数据库中数据重复，重复卡号为：");
			for (PiCardDO piCardDO : repeatDoList) {
				msg.append(piCardDO.getCode());
				msg.append(",");
			}
			throw new BizException(msg.toString());
		}
		
	}
	
	/**
	 * 插入数据
	 * @param cardDoS
	 * @throws BizException 
	 */
	private void insertDO(PiCardDO[] cardDoS) throws BizException{
		//查询卡类型
		Set<String> patCardTpSet=new HashSet<>();
		for (PiCardDO piCardDO : cardDoS) {
			patCardTpSet.add(piCardDO.getSd_patcardtp());
		}
		ICardtypeRService cardtpService=ServiceFinder.find(ICardtypeRService.class);
		String sql = SqlUtils.getInSqlByIds(PiPatCardTpDO.CODE, patCardTpSet.toArray(new String[0]));
		PiPatCardTpDO[] cardTpArr = cardtpService.find(sql,"",FBoolean.FALSE);
		if(ArrayUtil.isEmpty(cardTpArr)){
			throw new BizException("未查询到对应的卡类型");
		}
		Map<String, PiPatCardTpDO> cardTpMap=new HashMap<>();
		for (PiPatCardTpDO piPatCardTpDO : cardTpArr) {
			cardTpMap.put(piPatCardTpDO.getCode(), piPatCardTpDO);
		}
		
		for (PiCardDO piCardDO : cardDoS) {
			piCardDO.setId_grp(Context.get().getGroupId());
			piCardDO.setId_org(Context.get().getOrgId());
			PiPatCardTpDO cardTp = cardTpMap.get(piCardDO.getSd_patcardtp());
			if(cardTp==null){
				throw new BizException("未查询到"+piCardDO.getEu_cardsu()+"对应的卡类型");
			}
			piCardDO.setId_patcardtp(cardTp.getId_cardtp());
			piCardDO.setId_emp_entry(Context.get().getStuffId());
			piCardDO.setDt_entry(new FDateTime());
			piCardDO.setFg_get(FBoolean.FALSE);
			//对密码进行加密
			if(!StringUtil.isEmpty(piCardDO.getPassword()))
			{
				piCardDO.setPassword(PasswordUtil.EncryptPassword(piCardDO.getPassword()));
			}
			piCardDO.setStatus(DOStatus.NEW);
		}
		
		ICardCudService cardCudSeervice=ServiceFinder.find(ICardCudService.class);
		cardCudSeervice.save(cardDoS);
	}
	
	

	/**
	 * 创建临时表
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private String createTable(PiCardDO[] params) throws BizException {

		TamTableColumnDTO[] columns = new TamTableColumnDTO[1];
		columns[0] = getColumn("Code", "VARCHAR2(20)", FType.String);
		
		PiCardDO[] columnData = getTemTableData(params);

		String tableName = "pi_card_info_temporary";
		CreateTemTable bp = new CreateTemTable();
		bp.exec(tableName, columns, columnData);
		return tableName;
	}
	
	
	
	/**
	 * 列生产
	 * 
	 * @param columnName
	 * @param columnTp
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private TamTableColumnDTO getColumn(String columnName, String columnTp, FType type) {

		TamTableColumnDTO column = new TamTableColumnDTO();
		column.setColumn(columnName);
		column.setColumntp(columnTp);
		FArrayList array = new FArrayList();
		array.add(type);
		column.setDatatp(array);
		return column;
	}
	
	/**
	 * 获取临时表数据
	 * 
	 * @param ParamDTO
	 * @return
	 */
	private PiCardDO[] getTemTableData(PiCardDO[] params) {

		List<PiCardDO> reList = new ArrayList<PiCardDO>();
		for (PiCardDO param : params) {
			PiCardDO DTO = new PiCardDO();
			DTO.setCode(param.getCode());
//			DTO.setColumn2(param.getDt_mp_plan().toString());
//			DTO.setColumn3("~");
			reList.add(DTO);
		}
		return reList.toArray(new PiCardDO[reList.size()]);
	}
}
