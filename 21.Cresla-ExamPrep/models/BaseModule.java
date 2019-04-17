package cresla.models;

import cresla.interfaces.Module;

public abstract class BaseModule implements Module {
    private int id;

    protected BaseModule(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id = id;
    }

    @Override
    public String toString() {
//        {moduleType} Module – {moduleId}

        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        sb.append(" Module - ").append(this.getId()).append(System.lineSeparator());
        return sb.toString();

    }
}
