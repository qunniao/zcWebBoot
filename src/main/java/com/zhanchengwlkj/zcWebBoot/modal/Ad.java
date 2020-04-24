package com.zhanchengwlkj.zcWebBoot.modal;

public class Ad {
    private int id;
    private String title;
    private String img;
    private int menu_id;
    private int start_time;
    private int end_time;
    private int sort;
    private int status;
    private int create_time;
    private int look_times;
    private int click_times;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public int getLook_times() {
        return look_times;
    }

    public void setLook_times(int look_times) {
        this.look_times = look_times;
    }

    public int getClick_times() {
        return click_times;
    }

    public void setClick_times(int click_times) {
        this.click_times = click_times;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }
}
