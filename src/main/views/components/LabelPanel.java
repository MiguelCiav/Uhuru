package main.views.components;

import java.awt.GridBagConstraints;

public abstract class LabelPanel extends JPanelRound{

    protected GridBagConstraints constraints;
    protected abstract void setLabel();
    protected abstract void addLabel();

}
