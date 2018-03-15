package de.tudarmstadt.ukp.inception.kb;

import java.util.List;

import org.eclipse.rdf4j.model.IRI;

import de.tudarmstadt.ukp.clarin.webanno.api.annotation.action.AnnotationActionHandler;
import de.tudarmstadt.ukp.clarin.webanno.api.annotation.model.AnnotatorState;
import de.tudarmstadt.ukp.inception.kb.model.Entity;
import de.tudarmstadt.ukp.inception.kb.model.KnowledgeBase;

public interface KnowledgeBaseExtension
{
    /**
     * The bean name of this extension
     * @return bean name
     */
    String getBeanName();

    /**
     * Given a mention in the text, this method returns a list of ranked candidate entities
     * generated from a Knowledge Base. It only contains entities which are instances of a
     * pre-defined concept.
     *
     * @param aKB the KB used to generate candidates
     * @param aConceptIri the concept of which instances should be generated as candidates
     * @param aState AnnotatorState, used to get information about what surface form was marked
     * @param aActionHandler contains JCas, used to extract information about mention sentence
     *                       tokens
     * @return ranked list of entities, starting with the most probable entity
     */
    List<Entity> disambiguate(KnowledgeBase aKB, IRI aConceptIri, AnnotatorState aState, 
            AnnotationActionHandler aActionHandler);

}
