/*
 * Copyright (C) ExBin Project
 *
 * This application or library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * This application or library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along this application.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.exbin.framework.bined.options.panel;

import org.exbin.bined.swing.extended.theme.ExtendedCodeAreaThemeProfile;
import org.exbin.framework.bined.preferences.ThemeParameters;
import org.exbin.framework.gui.utils.LanguageUtils;
import org.exbin.framework.gui.utils.WindowUtils;
import org.exbin.framework.gui.utils.WindowUtils.DialogWrapper;
import org.exbin.framework.gui.utils.handler.DefaultControlHandler;
import org.exbin.framework.gui.utils.panel.DefaultControlPanel;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manage list of theme profiles panel.
 *
 * @version 0.2.0 2019/03/11
 * @author ExBin Project (http://exbin.org)
 */
public class ThemeProfilesPanel extends javax.swing.JPanel implements ProfileListPanel {

    private final java.util.ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(ThemeProfilesPanel.class);

    private boolean modified = false;

    public ThemeProfilesPanel() {
        initComponents();
        init();
    }

    private void init() {
        profilesList.setModel(new ProfilesListModel());
        profilesList.setCellRenderer(new ProfileCellRenderer());
        profilesList.addListSelectionListener((ListSelectionEvent e) -> updateStates());
    }

    private void updateStates() {
        int[] selectedIndices = profilesList.getSelectedIndices();
        boolean hasSelection = selectedIndices.length > 0;
        boolean singleSelection = selectedIndices.length == 1;
        boolean hasAnyItems = !getProfilesListModel().isEmpty();
        editButton.setEnabled(singleSelection);
        copyButton.setEnabled(singleSelection);
        selectAllButton.setEnabled(hasAnyItems);
        removeButton.setEnabled(hasSelection);

        if (hasSelection) {
            upButton.setEnabled(profilesList.getMaxSelectionIndex() >= selectedIndices.length);
            downButton.setEnabled(profilesList.getMinSelectionIndex() + selectedIndices.length < getProfilesListModel().getSize());
        } else {
            upButton.setEnabled(false);
            downButton.setEnabled(false);
        }
    }

    @Nonnull
    @Override
    public List<String> getProfileNames() {
        List<String> profileNames = new ArrayList<>();
        getProfilesListModel().profiles.forEach((profile) -> profileNames.add(profile.profileName));
        return profileNames;
    }

    @Nonnull
    private ProfilesListModel getProfilesListModel() {
        return ((ProfilesListModel) profilesList.getModel());
    }

    @Override
    public void addProfileListPanelListener(ListDataListener listener) {
        getProfilesListModel().addListDataListener(listener);
    }

    public ExtendedCodeAreaThemeProfile getProfile(int profileIndex) {
        return getProfilesListModel().getElementAt(profileIndex).themeProfile;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profilesListScrollPane = new javax.swing.JScrollPane();
        profilesList = new javax.swing.JList<>();
        profilesControlPanel = new javax.swing.JPanel();
        upButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        selectAllButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        hideButton = new javax.swing.JButton();
        copyButton = new javax.swing.JButton();

        profilesListScrollPane.setViewportView(profilesList);

        upButton.setText(resourceBundle.getString("upButton.text")); // NOI18N
        upButton.setEnabled(false);
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        downButton.setText(resourceBundle.getString("downButton.text")); // NOI18N
        downButton.setEnabled(false);
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        addButton.setText(resourceBundle.getString("addButton.text")); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText(resourceBundle.getString("removeButton.text")); // NOI18N
        removeButton.setEnabled(false);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        selectAllButton.setText(resourceBundle.getString("selectAllButton.text")); // NOI18N
        selectAllButton.setEnabled(false);
        selectAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllButtonActionPerformed(evt);
            }
        });

        editButton.setText(resourceBundle.getString("editButton.text")); // NOI18N
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        hideButton.setText(resourceBundle.getString("hideButton.text")); // NOI18N
        hideButton.setEnabled(false);
        hideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideButtonActionPerformed(evt);
            }
        });

        copyButton.setText(resourceBundle.getString("copyButton.text")); // NOI18N
        copyButton.setEnabled(false);
        copyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout profilesControlPanelLayout = new javax.swing.GroupLayout(profilesControlPanel);
        profilesControlPanel.setLayout(profilesControlPanelLayout);
        profilesControlPanelLayout.setHorizontalGroup(
            profilesControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilesControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profilesControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(copyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectAllButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(downButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(upButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hideButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        profilesControlPanelLayout.setVerticalGroup(
            profilesControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profilesControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(upButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(downButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectAllButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hideButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilesListScrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profilesControlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profilesControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(profilesListScrollPane)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        ProfilesListModel model = getProfilesListModel();
        int[] indices = profilesList.getSelectedIndices();
        int last = 0;
        for (int i = 0; i < indices.length; i++) {
            int next = indices[i];
            if (last != next) {
                ThemeProfile item = model.getElementAt(next);
                model.add(next - 1, item);
                profilesList.getSelectionModel().addSelectionInterval(next - 1, next - 1);
                model.remove(next + 1);
            } else {
                last++;
            }
        }
        wasModified();
    }//GEN-LAST:event_upButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        ProfilesListModel model = getProfilesListModel();
        int[] indices = profilesList.getSelectedIndices();
        int last = model.getSize() - 1;
        for (int i = indices.length; i > 0; i--) {
            int next = indices[i - 1];
            if (last != next) {
                ThemeProfile item = model.getElementAt(next);
                model.add(next + 2, item);
                profilesList.getSelectionModel().addSelectionInterval(next + 2, next + 2);
                model.remove(next);
            } else {
                last--;
            }
        }
        wasModified();
    }//GEN-LAST:event_downButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        ProfilesListModel model = getProfilesListModel();
        int selectedIndex = profilesList.getSelectedIndex();
        ThemeProfilePanel themeProfilePanel = new ThemeProfilePanel();
        themeProfilePanel.setThemeProfile(new ExtendedCodeAreaThemeProfile());
        NamedProfilePanel namedProfilePanel = new NamedProfilePanel(themeProfilePanel);
        DefaultControlPanel controlPanel = new DefaultControlPanel();
        JPanel dialogPanel = WindowUtils.createDialogPanel(namedProfilePanel, controlPanel);

        final DialogWrapper dialog = WindowUtils.createDialog(dialogPanel, null, "Add Theme Profile", Dialog.ModalityType.APPLICATION_MODAL);
        controlPanel.setHandler((DefaultControlHandler.ControlActionType actionType) -> {
            if (actionType != DefaultControlHandler.ControlActionType.CANCEL) {
                if (!isValidProfileName(namedProfilePanel.getProfileName())) {
                    JOptionPane.showMessageDialog(this, "Invalid profile name", "Profile Editation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ThemeProfile newProfileRecord = new ThemeProfile();
                ExtendedCodeAreaThemeProfile themeProfile = themeProfilePanel.getThemeProfile();
                newProfileRecord.profileName = namedProfilePanel.getProfileName();
                newProfileRecord.themeProfile = themeProfile;
                if (selectedIndex >= 0) {
                    profilesList.clearSelection();
                    model.add(selectedIndex, newProfileRecord);
                } else {
                    model.add(newProfileRecord);
                }
                wasModified();
            }

            dialog.close();
        });
        dialog.center();
        dialog.show();
        dialog.dispose();
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        ProfilesListModel model = getProfilesListModel();
        model.removeIndices(profilesList.getSelectedIndices());
        profilesList.clearSelection();
        wasModified();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void selectAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllButtonActionPerformed
        if (profilesList.getSelectedIndices().length < profilesList.getModel().getSize()) {
            profilesList.setSelectionInterval(0, profilesList.getModel().getSize() - 1);
        } else {
            profilesList.clearSelection();
        }
    }//GEN-LAST:event_selectAllButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        ProfilesListModel model = getProfilesListModel();
        int selectedIndex = profilesList.getSelectedIndex();
        ThemeProfile profileRecord = model.getElementAt(selectedIndex);
        ThemeProfilePanel themeProfilePanel = new ThemeProfilePanel();
        NamedProfilePanel namedProfilePanel = new NamedProfilePanel(themeProfilePanel);
        DefaultControlPanel controlPanel = new DefaultControlPanel();
        JPanel dialogPanel = WindowUtils.createDialogPanel(namedProfilePanel, controlPanel);

        final DialogWrapper dialog = WindowUtils.createDialog(dialogPanel, null, "Edit Theme Profile", Dialog.ModalityType.APPLICATION_MODAL);
        namedProfilePanel.setProfileName(profileRecord.profileName);
        themeProfilePanel.setThemeProfile(profileRecord.themeProfile);
        controlPanel.setHandler((DefaultControlHandler.ControlActionType actionType) -> {
            if (actionType != DefaultControlHandler.ControlActionType.CANCEL) {
                if (!isValidProfileName(namedProfilePanel.getProfileName())) {
                    JOptionPane.showMessageDialog(this, "Invalid profile name", "Profile Editation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ExtendedCodeAreaThemeProfile themeProfile = themeProfilePanel.getThemeProfile();
                profileRecord.profileName = namedProfilePanel.getProfileName();
                profileRecord.themeProfile = themeProfile;
                model.notifyProfileModified(selectedIndex);
                wasModified();
            }

            dialog.close();
        });
        dialog.center();
        dialog.show();
        dialog.dispose();
    }//GEN-LAST:event_editButtonActionPerformed

    private void hideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hideButtonActionPerformed

    private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyButtonActionPerformed
        ProfilesListModel model = getProfilesListModel();
        int selectedIndex = profilesList.getSelectedIndex();
        ThemeProfile profileRecord = model.getElementAt(selectedIndex);
        ThemeProfilePanel themeProfilePanel = new ThemeProfilePanel();
        themeProfilePanel.setThemeProfile(new ExtendedCodeAreaThemeProfile());
        NamedProfilePanel namedProfilePanel = new NamedProfilePanel(themeProfilePanel);
        DefaultControlPanel controlPanel = new DefaultControlPanel();
        JPanel dialogPanel = WindowUtils.createDialogPanel(namedProfilePanel, controlPanel);

        final DialogWrapper dialog = WindowUtils.createDialog(dialogPanel, null, "Copy Theme Profile", Dialog.ModalityType.APPLICATION_MODAL);
        themeProfilePanel.setThemeProfile(profileRecord.themeProfile);
        controlPanel.setHandler((DefaultControlHandler.ControlActionType actionType) -> {
            if (actionType != DefaultControlHandler.ControlActionType.CANCEL) {
                if (!isValidProfileName(namedProfilePanel.getProfileName())) {
                    JOptionPane.showMessageDialog(this, "Invalid profile name", "Profile Editation Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ThemeProfile newProfileRecord = new ThemeProfile();
                ExtendedCodeAreaThemeProfile themeProfile = themeProfilePanel.getThemeProfile();
                newProfileRecord.profileName = namedProfilePanel.getProfileName();
                newProfileRecord.themeProfile = themeProfile;
                if (selectedIndex >= 0) {
                    model.add(selectedIndex + 1, newProfileRecord);
                    profilesList.setSelectedIndex(selectedIndex + 1);
                } else {
                    profilesList.clearSelection();
                    model.add(newProfileRecord);
                }
                wasModified();
            }

            dialog.close();
        });
        dialog.center();
        dialog.show();
        dialog.dispose();
    }//GEN-LAST:event_copyButtonActionPerformed

    public boolean isModified() {
        return modified;
    }

    private void wasModified() {
        modified = true;
    }

    public void addProfilesListListener(ListDataListener listener) {
        getProfilesListModel().addListDataListener(listener);
    }

    private boolean isValidProfileName(@Nullable String profileName) {
        return profileName != null && !"".equals(profileName.trim());
    }

    public void loadFromParameters(ThemeParameters parameters) {
        List<ThemeProfile> profiles = new ArrayList<>();
        List<String> profileNames = parameters.getThemeProfilesList();
        for (int index = 0; index < profileNames.size(); index++) {
            ThemeProfile profile = new ThemeProfile();
            profile.profileName = profileNames.get(index);
            profile.themeProfile = parameters.getThemeProfile(index);
            profiles.add(profile);
        }

        ProfilesListModel model = getProfilesListModel();
        model.setProfiles(profiles);
    }

    public void saveToParameters(ThemeParameters parameters) {
        List<String> profileNames = parameters.getThemeProfilesList();
        for (int index = 0; index < profileNames.size(); index++) {
            parameters.clearTheme(index);
        }

        profileNames.clear();
        ProfilesListModel model = getProfilesListModel();
        List<ThemeProfile> profiles = model.getProfiles();
        for (int index = 0; index < profiles.size(); index++) {
            ThemeProfile profile = profiles.get(index);
            profileNames.add(profile.profileName);
            parameters.setThemeProfile(index, profile.themeProfile);
        }
        parameters.setThemeProfilesList(profileNames);
    }

    /**
     * Test method for this panel.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeDialog(new ThemeProfilesPanel());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton copyButton;
    private javax.swing.JButton downButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton hideButton;
    private javax.swing.JPanel profilesControlPanel;
    private javax.swing.JList<ThemeProfile> profilesList;
    private javax.swing.JScrollPane profilesListScrollPane;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton selectAllButton;
    private javax.swing.JButton upButton;
    // End of variables declaration//GEN-END:variables

    private final static class ThemeProfile {

        String profileName;
        boolean visible = true;
        ExtendedCodeAreaThemeProfile themeProfile;
    }

    @ParametersAreNonnullByDefault
    private static final class ProfilesListModel extends AbstractListModel<ThemeProfile> {

        private final List<ThemeProfile> profiles = new ArrayList<>();

        public ProfilesListModel() {
        }

        @Override
        public int getSize() {
            if (profiles == null) {
                return 0;
            }
            return profiles.size();
        }

        public boolean isEmpty() {
            return profiles == null || profiles.isEmpty();
        }

        @Nullable
        @Override
        public ThemeProfile getElementAt(int index) {
            return profiles.get(index);
        }

        @Nonnull
        public List<ThemeProfile> getProfiles() {
            return profiles;
        }

        public void setProfiles(List<ThemeProfile> profiles) {
            int size = this.profiles.size();
            if (size > 0) {
                this.profiles.clear();
                fireIntervalRemoved(this, 0, size - 1);
            }
            int profilesSize = profiles.size();
            if (profilesSize > 0) {
                this.profiles.addAll(profiles);
                fireIntervalAdded(this, 0, profilesSize - 1);
            }
        }

        public void addAll(List<ThemeProfile> list, int index) {
            if (index >= 0) {
                profiles.addAll(index, list);
                fireIntervalAdded(this, index, list.size() + index);
            } else {
                profiles.addAll(list);
                fireIntervalAdded(this, profiles.size() - list.size(), profiles.size());
            }
        }

        public void removeIndices(int[] indices) {
            for (int i = indices.length - 1; i >= 0; i--) {
                profiles.remove(indices[i]);
                fireIntervalRemoved(this, 0, indices[i]);
            }
        }

        public void remove(int index) {
            profiles.remove(index);
            fireIntervalRemoved(this, index, index);
        }

        public void add(int index, ThemeProfile item) {
            profiles.add(index, item);
            fireIntervalAdded(this, index, index);
        }

        public void add(ThemeProfile item) {
            profiles.add(item);
            int index = profiles.size() - 1;
            fireIntervalAdded(this, index, index);
        }

        public void notifyProfileModified(int index) {
            fireContentsChanged(this, index, index);
        }
    }

    @ParametersAreNonnullByDefault
    private static final class ProfileCellRenderer implements ListCellRenderer<ThemeProfile> {

        private final DefaultListCellRenderer defaultListCellRenderer = new DefaultListCellRenderer();

        @Override
        public Component getListCellRendererComponent(JList<? extends ThemeProfile> list, ThemeProfile value, int index, boolean isSelected, boolean cellHasFocus) {
            return defaultListCellRenderer.getListCellRendererComponent(list, value.profileName, index, isSelected, cellHasFocus);
        }
    }
}
