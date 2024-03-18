package Model;

/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2018
 * </p>
 * <p>
 * Generische Klasse BinaryTree<CT>
 * </p>
 * <p>
 * Mithilfe der generischen Klasse BinaryTree koennen beliebig viele
 * Inhaltsobjekte vom Typ CT in einem Binaerbaum verwaltet werden. Ein
 * Objekt der Klasse stellt entweder einen leeren Baum dar oder verwaltet ein
 * Inhaltsobjekt sowie einen linken und einen rechten Teilbaum, die ebenfalls
 * Objekte der generischen Klasse BinaryTree sind.
 * </p>
 *
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule
 * @version Generisch_03 2014-03-01
 */
public class BinaryTree<ContentType> {

	//TODO 01: Vervollständige die Klasse BinaryTree gemäß Dokumentation. Beachte dabei, dass du auf die Inhaltsobjekte des Objekts node per Punktnotation direkt zugreifen kannst, z.B. per "this.node.content".
	/* --------- Anfang der privaten inneren Klasse -------------- */

	/**
	 * Durch diese innere Klasse kann man dafuer sorgen, dass ein leerer Baum
	 * null ist, ein nicht-leerer Baum jedoch immer eine nicht-null-Wurzel sowie
	 * nicht-null-Teilbaeume, ggf. leere Teilbaeume hat.
	 */
	private class BTNode<CT> {

		private CT content;
		private BinaryTree<CT> left, right;

		public BTNode(CT pContent) {
			// Der Knoten hat einen linken und einen rechten Teilbaum, die
			// beide von null verschieden sind. Also hat ein Blatt immer zwei
			// leere Teilbaeume unter sich.
			this.content = pContent;
			left = new BinaryTree<CT>();
			right = new BinaryTree<CT>();
		}

	}

	/* ----------- Ende der privaten inneren Klasse -------------- */

	private BTNode<ContentType> node;

	/**
	 * Nach dem Aufruf des Konstruktors existiert ein leerer Binaerbaum.
	 */
	public BinaryTree() {
		//TODO 01a
		node = null;
	}

	/**
	 * Falls der Parameter pContent ungleich null ist, existiert nach dem Aufruf
	 * des Konstruktors der Binaerbaum und hat pContent als Inhaltsobjekt und
	 * zwei leere Teilbaeume. Falls der Parameter null ist, wird ein leerer
	 * Binaerbaum erzeugt.
	 *
	 * @param pContent
	 *            das Inhaltsobjekt des Wurzelknotens vom Typ CT
	 */
	public BinaryTree(ContentType pContent) {
		//TODO 01b
		if(pContent == null){
			node = null;
		}else{
			node = new BTNode<>(pContent);
		}


	}

	/**
	 * Falls der Parameter pContent ungleich null ist, wird ein Binaerbaum mit
	 * pContent als Inhalt und den beiden Teilbaeume pLeftTree und pRightTree
	 * erzeugt. Sind pLeftTree oder pRightTree gleich null, wird der
	 * entsprechende Teilbaum als leerer Binaerbaum eingefuegt. So kann es also
	 * nie passieren, dass linke oder rechte Teilbaeume null sind. Falls der
	 * Parameter pContent gleich null ist, wird ein leerer Binaerbaum erzeugt.
	 *
	 * @param pContent
	 *            das Inhaltsobjekt des Wurzelknotens vom Typ CT
	 * @param pLeftTree
	 *            der linke Teilbaum vom Typ BinaryTree<CT>
	 * @param pRightTree
	 *            der rechte Teilbaum vom Typ BinaryTree<CT>
	 */
	public BinaryTree(ContentType pContent, BinaryTree<ContentType> pLeftTree, BinaryTree<ContentType> pRightTree) {
		//TODO 01c
		if(pContent != null){
			node = new BTNode<>(pContent);
			if(pLeftTree != null){
				setLeftTree(pLeftTree);
			}
			if(pRightTree != null){
				setRightTree(pRightTree);
			}

		}else{
			node = null;
		}

	}

	/**
	 * Diese Anfrage liefert den Wahrheitswert true, falls der Binaerbaum leer
	 * ist, sonst liefert sie den Wert false.
	 *
	 * @return true, falls der Binaerbaum leer ist, sonst false
	 */
	public boolean isEmpty() {
		//TODO 01d
		return node == null;
	}

	/**
	 * Falls pContent null ist, geschieht nichts. <br />
	 * Ansonsten: Falls der Binaerbaum leer ist, wird der Parameter pContent als
	 * Inhaltsobjekt sowie ein leerer linker und rechter Teilbaum eingefuegt.
	 * Ist der Binaerbaum nicht leer, wird das Inhaltsobjekt durch pContent
	 * ersetzt. Die Teilbaeume werden nicht geaendert.
	 *
	 * @param pContent
	 *            neues Inhaltsobjekt vom Typ CT
	 */
	public void setContent(ContentType pContent) {
		//TODO 01e
		if(pContent != null){
			if(node == null){
				node = new BTNode<>(pContent);
			}else{
				node.content = pContent;
			}
		}
	}

	/**
	 * Diese Anfrage liefert das Inhaltsobjekt des Binaerbaums. Falls der
	 * Binaerbaum leer ist, wird null zurueckgegeben.
	 *
	 * @return das Inhaltsobjekt der Wurzel vom Typ CT bzw. null, falls
	 *         der Binaerbaum leer ist
	 */
	public ContentType getContent() {
		//TODO 01f
		if(node == null)
			return null;
		return node.content;
	}

	/**
	 * Falls der Parameter null ist, geschieht nichts. Falls der Binaerbaum leer
	 * ist, wird pTree nicht angehaengt. Andernfalls erhaelt der Binaerbaum den
	 * uebergebenen BinaryTree als linken Teilbaum.
	 *
	 * @param pTree
	 *            neuer linker Teilbaum vom Typ BinaryTree<CT>
	 */
	public void setLeftTree(BinaryTree<ContentType> pTree) {
		//TODO 01g
		if(pTree != null && !isEmpty())
			node.left = pTree;
	}

	/**
	 * Falls der Parameter null ist, geschieht nichts. Falls der Binaerbaum leer
	 * ist, wird pTree nicht angehaengt. Andernfalls erhaelt der Binaerbaum den
	 * uebergebenen BinaryTree als rechten Teilbaum.
	 *
	 * @param pTree
	 *            neuer linker Teilbaum vom Typ BinaryTree<CT>
	 */
	public void setRightTree(BinaryTree<ContentType> pTree) {
		//TODO 01h
		if(pTree != null && !isEmpty())
			node.right = pTree;
	}

	/**
	 * Diese Anfrage liefert den linken Teilbaum des Binaerbaumes. Falls der
	 * Binaerbaum leer ist, wird null zurueckgegeben.
	 *
	 * @return linker Teilbaum vom Typ BinaryTree<CT> oder null, falls
	 * der aktuelle Binaerbaum leer ist
	 */
	public BinaryTree<ContentType> getLeftTree() {
		//TODO 01i
		if(node == null)
			return null;
		return node.left;
	}

	/**
	 * Diese Anfrage liefert den rechten Teilbaum des Binaerbaumes. Falls der
	 * Binaerbaum (this) leer ist, wird null zurueckgegeben.
	 *
	 * @return rechter Teilbaum vom Typ BinaryTree<CT> oder null, falls
	 * der aktuelle Binaerbaum (this) leer ist
	 */
	public BinaryTree<ContentType> getRightTree() {
		//TODO 01j
		if (node == null) {
			return null;
		}
		return node.right;
	}

}
