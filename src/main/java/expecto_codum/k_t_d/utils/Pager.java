package expecto_codum.k_t_d.utils;


import org.springframework.data.domain.Page;

import expecto_codum.k_t_d.articulo.Articulo;


public class Pager {

    private final Page<Articulo> articulo;

    public Pager(Page<Articulo> posts) {
        this.articulo = posts;
    }

    public int getPageIndex() {
        return articulo.getNumber() + 1;
    }

    public int getPageSize() {
        return articulo.getSize();
    }

    public boolean hasNext() {
        return articulo.hasNext();
    }

    public boolean hasPrevious() {
        return articulo.hasPrevious();
    }

    public int getTotalPages() {
        return articulo.getTotalPages();
    }

    public long getTotalElements() {
        return articulo.getTotalElements();
    }

    public Page<Articulo> getPosts() {
        return articulo;
    }

    public boolean indexOutOfBounds() {
        return getPageIndex() < 0 || getPageIndex() > getTotalElements();
    }

}
