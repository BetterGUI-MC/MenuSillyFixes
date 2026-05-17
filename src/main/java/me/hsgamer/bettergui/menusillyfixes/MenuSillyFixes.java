package me.hsgamer.bettergui.menusillyfixes;

import io.github.projectunified.minelib.plugin.base.Loadable;
import me.hsgamer.bettergui.api.addon.GetPlugin;
import me.hsgamer.bettergui.menusillyfixes.fix.UpdateInventoryOnClose;
import me.hsgamer.hscore.expansion.common.Expansion;

import java.util.ArrayList;
import java.util.List;

public final class MenuSillyFixes implements Expansion, GetPlugin {
    private final List<Loadable> fixes = new ArrayList<>();

    @Override
    public boolean onLoad() {
        fixes.add(new UpdateInventoryOnClose(this));
        fixes.forEach(Loadable::load);
        return true;
    }

    @Override
    public void onEnable() {
        fixes.forEach(Loadable::enable);
    }

    @Override
    public void onDisable() {
        fixes.forEach(Loadable::disable);
        fixes.clear();
    }
}
