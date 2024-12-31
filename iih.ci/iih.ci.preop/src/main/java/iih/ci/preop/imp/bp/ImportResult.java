package iih.ci.preop.imp.bp;

public enum ImportResult {
    SUCCESS(""),
    SIGN_ERROR("部分医嘱签署校验未通过，请检查后手动签署。");
    
    private String message;
    private ImportResult(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return this.message;
    }
}
