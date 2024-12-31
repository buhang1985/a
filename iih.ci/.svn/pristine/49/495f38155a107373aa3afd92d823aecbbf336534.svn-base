package iih.ci.ord.s.external.thirdws.op.base;

import org.springframework.transaction.TransactionStatus;

import iih.ci.ord.i.external.thirdws.base.EmsRstDTO;
import iih.ci.ord.i.external.thirdws.base.EmsValidateRstDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.blood.ruimei.s.bp.ConvertDTOs2XmlUtils;
import iih.ci.ord.s.external.thirdws.base.IEmsSaveBP;
import iih.ci.ord.s.external.thirdws.utils.LogUtils;
import iih.ci.ord.s.external.thirdws.utils.RstMsgBP;
import xap.mw.core.data.BizException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;

/**
 * 公共处理逻辑
 * 
 * @author zhangwq
 *
 */
public class OpEmsCommonSaveBP extends OpEmsBaseSaveBP {
	public OpEmsCommonSaveBP() {
	}

	public OpEmsCommonSaveBP(EntWsDTO dataSource) {
		super(dataSource);
	}

	@Override
	public String save(final EntWsDTO entwsdto) throws BizException {
		if(this.getValidate()!=null){
			EmsValidateRstDTO validaterst = this.getValidate().validate(entwsdto);
			if(validaterst!=null && EmsValidateRstDTO.ERROR == validaterst.getLevel()){
				EmsRstDTO rst = new EmsRstDTO();
				rst.setResultcode("1");
				rst.setResultmsg(validaterst.getMsgInfoList().AsString());
				return this.rstMsg(rst);
			}
		}
		return TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
			@Override
			public String doInTransaction(TransactionStatus status) {
				try {
					return getSaveAction().save(entwsdto);
				} catch (Exception e) {
					e.printStackTrace();
					LogUtils.Logger(e.getMessage(), e);
					throw new RuntimeException(e.getMessage());
				}
			}
		});
	}
	public String rstMsg(EmsRstDTO rstdto) throws BizException {
		ConvertDTOs2XmlUtils utils = new ConvertDTOs2XmlUtils();
		return utils.exec(new EmsRstDTO[]{rstdto}, "root", "");
	}
}
