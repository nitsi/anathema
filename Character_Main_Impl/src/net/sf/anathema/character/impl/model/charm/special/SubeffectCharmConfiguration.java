package net.sf.anathema.character.impl.model.charm.special;

import net.sf.anathema.character.generic.framework.additionaltemplate.model.ICharacterModelContext;
import net.sf.anathema.character.generic.magic.ICharm;
import net.sf.anathema.character.generic.magic.charms.special.ISubeffect;
import net.sf.anathema.character.generic.magic.charms.special.ISubeffectCharm;
import net.sf.anathema.character.model.charm.IExtendedCharmLearnableArbitrator;
import net.sf.anathema.character.model.charm.special.ISubeffectCharmConfiguration;

public class SubeffectCharmConfiguration extends MultipleEffectCharmConfiguration implements
    ISubeffectCharmConfiguration {

  private final double pointCost;

  public SubeffectCharmConfiguration(
      ICharacterModelContext context,
      ICharm charm,
      ISubeffectCharm visited,
      IExtendedCharmLearnableArbitrator arbitrator) {
    super(context, charm, visited, arbitrator);
    this.pointCost = visited.getPointCost();
  }

  @Override
  public int getCreationLearnCount() {
    return super.getCreationLearnCount() > 0 ? 1 : 0;
  }

  @Override
  public int getCurrentLearnCount() {
    return super.getCurrentLearnCount() > 0 ? 1 : 0;
  }

  @Override
  public int getCreationLearnedSubeffectCount() {
    int count = 0;
    for (ISubeffect subeffect : getEffects()) {
      if (subeffect.isCreationLearned()) {
        count++;
      }
    }
    return count;
  }

  @Override
  public int getExperienceLearnedSubeffectCount() {
    int count = 0;
    for (ISubeffect subeffect : getEffects()) {
      if (subeffect.isLearned() && !subeffect.isCreationLearned()) {
        count++;
      }
    }
    return count;
  }

  @Override
  public double getPointCostPerEffect() {
    return pointCost;
  }
}