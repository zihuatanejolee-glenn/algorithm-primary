package thread_safe;

public class Station {
    private Integer currentSaleWindowsCounts = 0;
    private Integer sumSaleWindowsCounts;

    private String aaaaa = "strstrstrsrtsrt";


    public Integer getCurrentSaleWindowsCounts() {
        return currentSaleWindowsCounts;
    }

    public void setCurrentSaleWindowsCounts(Integer currentSaleWindowsCounts) {
        this.currentSaleWindowsCounts = currentSaleWindowsCounts;
    }

    public Integer getSumSaleWindowsCounts() {
        return sumSaleWindowsCounts;
    }

    public void setSumSaleWindowsCounts(Integer sumSaleWindowsCounts) {
        this.sumSaleWindowsCounts = sumSaleWindowsCounts;
    }
}
