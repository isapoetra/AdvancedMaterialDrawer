package de.madcyph3r.example.example.functionally;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import de.madcyph3r.example.example.functionally.noClosePrevDrawerActivity.NoCloseActivity;
import de.madcyph3r.example.example.FragmentInstruction;
import de.madcyph3r.materialnavigationdrawer.MaterialNavigationDrawer;
import de.madcyph3r.materialnavigationdrawer.menu.MaterialMenu;
import de.madcyph3r.materialnavigationdrawer.menu.item.MaterialSection;

/**
 * Created by marc on 23.02.2015.
 */
public class NoClosePrevDrawerActivity_Activity extends MaterialNavigationDrawer {

    // info: see manifest for the dark theme

    MaterialNavigationDrawer drawer = null;

    // Don't close drawer activity
    @Override
    public boolean finishActivityOnNewIntent() {
        return false;
    }

    @Override
    public int headerType() {
        // set type. you get the available constant from MaterialNavigationDrawer class
        return MaterialNavigationDrawer.DRAWERHEADER_NO_HEADER;
    }

    @Override
    public void init(Bundle savedInstanceState) {

        Bundle bundle = new Bundle();
        bundle.putString("instruction", "Open the drawer and choose the 'start activity' section. Then press back, " +
                "you will get back to this activity.");

        drawer = this;

        // create menu
        MaterialMenu menu = new MaterialMenu();

        //create instruction fragment
        Fragment fragmentInstruction = new FragmentInstruction();
        fragmentInstruction.setArguments(bundle);

        // menu items
        MaterialSection instruction = this.newSection("Instruction", fragmentInstruction , false, menu);
        instruction.setFragmentTitle("No Close Previous Drawer Activity");
        this.newDevisor(menu);
        this.newLabel("Label", false, menu);
        this.newSection("start activity", new Intent(this, NoCloseActivity.class), false, menu);

        // set custom menu
        this.setCustomMenu(menu);
    }
}
