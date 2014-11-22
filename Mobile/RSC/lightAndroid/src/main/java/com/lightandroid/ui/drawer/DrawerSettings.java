package com.lightandroid.ui.drawer;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

/**
 * Created by David on 9.11.2014..
 */
public class DrawerSettings {

    private Position position;
    private int layoutRes;
    private MenuDrawer.Type type;
    private int dragMode;
    private int dropShadowRes;
    private int drawerSize;


    public DrawerSettings position(Position position) {
        this.position = position;
        return this;
    }

    public DrawerSettings layoutRes(int layoutRes) {
        this.layoutRes = layoutRes;
        return this;
    }

    public DrawerSettings type(MenuDrawer.Type type) {
        this.type = type;
        return this;
    }

    public DrawerSettings dragMode(int dragMode) {
        this.dragMode = dragMode;
        return this;
    }

    public DrawerSettings dropShadowRes(int dropShadowRes) {
        this.dropShadowRes = dropShadowRes;
        return this;
    }

    public DrawerSettings drawerSize(int drawerSize) {
        this.drawerSize = drawerSize;
        return this;
    }

    public Position getPosition() {
        return position;
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    public MenuDrawer.Type getType() {
        return type;
    }

    public int getDragMode() {
        return dragMode;
    }

    public int getDropShadowRes() {
        return dropShadowRes;
    }

    public int getDrawerSize() {
        return drawerSize;
    }
}
