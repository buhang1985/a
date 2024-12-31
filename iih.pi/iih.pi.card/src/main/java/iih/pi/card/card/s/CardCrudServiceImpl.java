package iih.pi.card.card.s;
import iih.pi.card.card.d.CardSuEnum;
import iih.pi.card.card.d.PiCardDO;
import iih.pi.card.card.d.desc.PiCardDODesc;
import iih.pi.card.card.i.ICardCudService;
import iih.pi.card.card.i.ICardRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;


/**
 * 患者就诊卡AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICardCudService.class,ICardRService.class}, binding=Binding.JSONRPC)
public class CardCrudServiceImpl extends  BaseDOService<PiCardDO> implements ICardCudService,ICardRService {

    public CardCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiCardDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }

	@Override
	public PagingRtnData<PiCardDO> findByQCondAndPageInfo(
			QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)
			throws BizException {
		PagingRtnData<PiCardDO> ret=super.findByQCondAndPageInfo(qryRootNodeDTO, orderStr, pg);
		FArrayList data=ret.getPageData();
		if(data!=null&&data.size()>0) {
			for(Object card:data) {
				setCardEuName(card);
			}
		}
		return ret;
	}
    
	private void setCardEuName(Object card) {
		if(card instanceof PiCardDO) {
			PiCardDO realcard=(PiCardDO)card;
			Integer cardsu=realcard.getEu_cardsu();
			if(CardSuEnum.BLANK.equals(cardsu)) {
				realcard.setName_cardsu("空白");
			}else if(CardSuEnum.USING.equals(cardsu)) {
				realcard.setName_cardsu("在用");
			}else if(CardSuEnum.LOSE.equals(cardsu)) {
				realcard.setName_cardsu("挂失");
			}else if(CardSuEnum.CANCEL.equals(cardsu)) {
				realcard.setName_cardsu("注销");
			}
		}
	}
}

