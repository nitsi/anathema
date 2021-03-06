package net.sf.anathema.character.generic.character;

import net.sf.anathema.character.generic.additionaltemplate.IAdditionalModel;
import net.sf.anathema.character.generic.health.HealthLevelType;
import net.sf.anathema.character.generic.magic.ICharm;
import net.sf.anathema.character.generic.magic.IGenericCombo;
import net.sf.anathema.character.generic.magic.IMagic;
import net.sf.anathema.character.generic.template.ICharacterTemplate;
import net.sf.anathema.character.generic.template.magic.IGenericCharmConfiguration;
import net.sf.anathema.character.generic.traits.IGenericTrait;
import net.sf.anathema.character.generic.traits.INamedGenericTrait;
import net.sf.anathema.character.generic.traits.ITraitType;
import net.sf.anathema.character.generic.traits.groups.IIdentifiedTraitTypeGroup;
import net.sf.anathema.lib.control.IChangeListener;
import net.sf.anathema.lib.util.IdentifiedInteger;

import java.util.List;

public interface IGenericCharacter extends ILimitationContext, IMagicCollection, IGenericCharmConfiguration {

  IGenericDescription getDescription();

  boolean isAlienCharm(ICharm charm);

  ICharacterTemplate getTemplate();

  IGenericTrait[] getBackgrounds();

  INamedGenericTrait[] getSpecialties(ITraitType traitType);

  INamedGenericTrait[] getSubTraits(ITraitType traitType);

  int getHealthLevelTypeCount(HealthLevelType type);

  String getPeripheralPool();

  int getPeripheralPoolValue();

  String getPersonalPool();

  int getPersonalPoolValue();

  int getOverdrivePoolValue();

  IdentifiedInteger[] getComplexPools();

  int getAttunedPoolValue();

  IAdditionalModel getAdditionalModel(String templateId);

  IConcept getConcept();

  List<IMagic> getAllLearnedMagic();

  int getLearnCount(ICharm charm);

  IGenericCombo[] getCombos();

  boolean isExperienced();

  int getPainTolerance();

  IIdentifiedTraitTypeGroup[] getAbilityTypeGroups();

  IIdentifiedTraitTypeGroup[] getAttributeTypeGroups();

  IIdentifiedTraitTypeGroup[] getYoziTypeGroups();

  int getTotalExperiencePoints();

  int getSpentExperiencePoints();

  String[] getLearnedEffects(ICharm charm);

  boolean isMultipleEffectCharm(ICharm magic);

  boolean isSubeffectCharm(ICharm magic);

  void addSpecialtyListChangeListener(IChangeListener listener);
  
  ICharm[] getGenericCharms();

  <T> List<T> getAllRegistered(Class<T> interfaceClass);
}