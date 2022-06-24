package com.byoskill.training.junit.realapp.junitrealapp.adapters.anime;

public class PageInfo {
    private int total;
    private int currentPage;
    private int lastPage;
    private boolean hasNextPage;
    private int perPage;

    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("total=").append(total);
        sb.append(", currentPage=").append(currentPage);
        sb.append(", lastPage=").append(lastPage);
        sb.append(", hasNextPage=").append(hasNextPage);
        sb.append(", perPage=").append(perPage);
        sb.append('}');
        return sb.toString();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}
