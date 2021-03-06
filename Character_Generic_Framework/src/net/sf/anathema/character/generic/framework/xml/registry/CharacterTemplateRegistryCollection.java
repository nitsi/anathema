package net.sf.anathema.character.generic.framework.xml.registry;

import net.sf.anathema.character.generic.framework.ICharacterTemplateExtensionResourceCache;
import net.sf.anathema.character.generic.framework.ICharacterTemplateRegistryCollection;
import net.sf.anathema.character.generic.framework.xml.GenericCharacterTemplate;
import net.sf.anathema.character.generic.framework.xml.abilitygroup.GenericGroupedTraitTypeProvider;
import net.sf.anathema.character.generic.framework.xml.creation.GenericBonusPointCosts;
import net.sf.anathema.character.generic.framework.xml.creation.GenericCreationPoints;
import net.sf.anathema.character.generic.framework.xml.essence.GenericEssenceTemplate;
import net.sf.anathema.character.generic.framework.xml.experience.GenericExperiencePointCosts;
import net.sf.anathema.character.generic.framework.xml.health.GenericHealthTemplate;
import net.sf.anathema.character.generic.framework.xml.magic.GenericMagicTemplate;
import net.sf.anathema.character.generic.framework.xml.presentation.GenericPresentationTemplate;
import net.sf.anathema.character.generic.framework.xml.rules.GenericAdditionalRules;
import net.sf.anathema.character.generic.framework.xml.trait.GenericTraitTemplateFactory;
import net.sf.anathema.character.generic.framework.xml.trait.pool.GenericTraitTemplatePool;

public class CharacterTemplateRegistryCollection implements ICharacterTemplateRegistryCollection {

  private final IXmlTemplateRegistry<GenericCharacterTemplate> characterTemplateRegistry;
  private final IXmlTemplateRegistry<GenericGroupedTraitTypeProvider> groupedTraitTypeRegistry;
  private final IXmlTemplateRegistry<GenericEssenceTemplate> essenceRegistry;
  private final IXmlTemplateRegistry<GenericCreationPoints> creationPointsRegistry;
  private final IXmlTemplateRegistry<GenericBonusPointCosts> bonusPointsRegistry;
  private final IXmlTemplateRegistry<GenericExperiencePointCosts> experienceTemplateRegistry;
  private final IXmlTemplateRegistry<GenericTraitTemplateFactory> traitFactoryRegistry;
  private final IXmlTemplateRegistry<GenericTraitTemplatePool> traitTemplatePoolRegistry;
  private final IXmlTemplateRegistry<GenericMagicTemplate> magicTemplateRegistry;
  private final IXmlTemplateRegistry<GenericPresentationTemplate> presentationTemplateRegistry;
  private final IXmlTemplateRegistry<GenericHealthTemplate> healthTemplateRegistry;
  private final IXmlTemplateRegistry<GenericAdditionalRules> rulesRegistry;

  public CharacterTemplateRegistryCollection(ICharacterTemplateExtensionResourceCache cache) {
	  characterTemplateRegistry = new XmlTemplateRegistry<GenericCharacterTemplate>(cache);
	  groupedTraitTypeRegistry = new XmlTemplateRegistry<GenericGroupedTraitTypeProvider>(cache);
	  essenceRegistry = new XmlTemplateRegistry<GenericEssenceTemplate>(cache);
	  creationPointsRegistry = new XmlTemplateRegistry<GenericCreationPoints>(cache);
	  bonusPointsRegistry = new XmlTemplateRegistry<GenericBonusPointCosts>(cache);
	  experienceTemplateRegistry = new XmlTemplateRegistry<GenericExperiencePointCosts>(cache);
	  traitFactoryRegistry = new XmlTemplateRegistry<GenericTraitTemplateFactory>(cache);
	  traitTemplatePoolRegistry = new XmlTemplateRegistry<GenericTraitTemplatePool>(cache);
	  magicTemplateRegistry = new XmlTemplateRegistry<GenericMagicTemplate>(cache);
	  presentationTemplateRegistry = new XmlTemplateRegistry<GenericPresentationTemplate>(cache);
	  healthTemplateRegistry = new XmlTemplateRegistry<GenericHealthTemplate>(cache);
	  rulesRegistry = new XmlTemplateRegistry<GenericAdditionalRules>(cache);
  }
  
  @Override
  public IXmlTemplateRegistry<GenericCharacterTemplate> getCharacterTemplateRegistry() {
    return characterTemplateRegistry;
  }

  @Override
  public IXmlTemplateRegistry<GenericGroupedTraitTypeProvider> getTraitGroupTemplateRegistry() {
    return groupedTraitTypeRegistry;
  }

  @Override
  public IXmlTemplateRegistry<GenericEssenceTemplate> getEssenceTemplateRegistry() {
    return essenceRegistry;
  }

  @Override
  public IXmlTemplateRegistry<GenericCreationPoints> getCreationPointTemplateRegistry() {
    return creationPointsRegistry;
  }

  @Override
  public IXmlTemplateRegistry<GenericBonusPointCosts> getBonusPointTemplateRegistry() {
    return bonusPointsRegistry;
  }

  @Override
  public IXmlTemplateRegistry<GenericExperiencePointCosts> getExperienceTemplateRegistry() {
    return experienceTemplateRegistry;
  }

  @Override
  public IXmlTemplateRegistry<GenericTraitTemplateFactory> getTraitFactoryRegistry() {
    return traitFactoryRegistry;
  }

  @Override
  public IXmlTemplateRegistry<GenericTraitTemplatePool> getTraitTemplatePoolRegistry() {
    return traitTemplatePoolRegistry;
  }

  @Override
  public IXmlTemplateRegistry<GenericMagicTemplate> getMagicTemplateRegistry() {
    return magicTemplateRegistry;
  }

  @Override
  public IXmlTemplateRegistry<GenericPresentationTemplate> getPresentationTemplateRegistry() {
    return presentationTemplateRegistry;
  }

  @Override
  public IXmlTemplateRegistry<GenericHealthTemplate> getHealthTemplateRegistry() {
    return healthTemplateRegistry;
  }

  @Override
  public IXmlTemplateRegistry<GenericAdditionalRules> getAdditionalRulesRegistry() {
    return rulesRegistry;
  }
}