package net.sf.anathema.character.presenter.charm.tree;

import net.sf.anathema.character.generic.magic.charms.GroupCharmTree;
import net.sf.anathema.character.presenter.charm.CharacterAlienCharmPresenter;
import net.sf.anathema.character.presenter.charm.CharacterCharmDye;
import net.sf.anathema.character.presenter.charm.CharacterCharmGroupChangeListener;
import net.sf.anathema.character.presenter.charm.CharacterCharmModel;
import net.sf.anathema.character.presenter.charm.CharacterCharmTreeViewProperties;
import net.sf.anathema.character.presenter.charm.CharacterCharmTypes;
import net.sf.anathema.character.presenter.charm.CharacterGroupCharmTree;
import net.sf.anathema.character.presenter.charm.CharacterGroupCollection;
import net.sf.anathema.character.presenter.charm.CharacterSpecialCharmPresenter;
import net.sf.anathema.character.presenter.charm.LearnInteractionPresenter;
import net.sf.anathema.character.view.magic.IMagicViewFactory;
import net.sf.anathema.charmtree.presenter.AbstractCascadePresenter;
import net.sf.anathema.charmtree.presenter.CharmFilterContainer;
import net.sf.anathema.charmtree.presenter.view.CharmDisplayPropertiesMap;
import net.sf.anathema.charmtree.presenter.view.ICharmTreeViewProperties;
import net.sf.anathema.charmtree.presenter.view.ICharmView;
import net.sf.anathema.lib.gui.IPresenter;
import net.sf.anathema.lib.resources.IResources;
import net.sf.anathema.lib.util.IIdentificate;
import net.sf.anathema.platform.svgtree.document.visualizer.ITreePresentationProperties;

public class CharacterCharmTreePresenter extends AbstractCascadePresenter implements IPresenter {

  private final ICharmView view;
  private final CharacterCharmModel model;

  public CharacterCharmTreePresenter(IResources resources, IMagicViewFactory factory, CharacterCharmModel charmModel,
                                     ITreePresentationProperties presentationProperties, CharmDisplayPropertiesMap displayPropertiesMap) {
    super(resources);
    this.model = charmModel;
    ICharmTreeViewProperties viewProperties = new CharacterCharmTreeViewProperties(resources, model.getCharmConfiguration(), model.getMagicDescriptionProvider());
    this.view = factory.createCharmSelectionView(viewProperties);
    CharacterCharmGroupChangeListener charmGroupChangeListener = new CharacterCharmGroupChangeListener(model.getCharmConfiguration(), filterSet,
            model.getEdition(), view.getCharmTreeRenderer(),
            displayPropertiesMap);
    CharacterCharmDye dye = new CharacterCharmDye(model, charmGroupChangeListener, presentationProperties.getColor(), view);
    setCharmTypes(new CharacterCharmTypes(charmModel));
    setChangeListener(charmGroupChangeListener);
    setView(view);
    setSpecialPresenter(new CharacterSpecialCharmPresenter(view, resources, charmGroupChangeListener, charmModel, presentationProperties));
    setCharmDye(dye);
    setAlienCharmPresenter(new CharacterAlienCharmPresenter(model, view));
    setInteractionPresenter(new LearnInteractionPresenter(model, view, charmGroupChangeListener, viewProperties, dye));
    setCharmGroups(new CharacterGroupCollection(model));
  }

  public ICharmView getView() {
    return view;
  }

  @Override
  protected CharmFilterContainer getFilterContainer() {
    return model.getCharmConfiguration();
  }

  @Override
  protected GroupCharmTree getCharmTree(IIdentificate cascadeType) {
    return new CharacterGroupCharmTree(model, cascadeType);
  }
}
