import java.util.Iterator;
import java.util.LinkedList;
import org.eclipse.egit.core.internal.util.ResourceUtil;
import org.eclipse.egit.ui.internal.UIIcons;
import org.eclipse.jgit.diff.RenameDetector;
	 * @param repository
	 * @param markTreeFilters
	 *            optional filters for marking entries, see
	 *            {@link #isMarked(int)}
	public static FileDiff[] compute(final Repository repository,
			final TreeWalk walk, final RevCommit commit,
			final TreeFilter... markTreeFilters) throws MissingObjectException,
			IncorrectObjectTypeException, CorruptObjectException, IOException {
			List<DiffEntry> xentries = new LinkedList<DiffEntry>(entries);
			RenameDetector detector = new RenameDetector(repository);
			detector.addAll(entries);
			List<DiffEntry> renames = detector.compute(walk.getObjectReader(),
					org.eclipse.jgit.lib.NullProgressMonitor.INSTANCE);
			for (DiffEntry m : renames) {
				final FileDiff d = new FileDiff(commit, m);
				r.add(d);
				for (Iterator<DiffEntry> i = xentries.iterator(); i.hasNext();) {
					DiffEntry n = i.next();
					if (m.getOldPath().equals(n.getOldPath()))
						i.remove();
					else if (m.getNewPath().equals(n.getNewPath()))
						i.remove();
				}
			}
			for (DiffEntry m : xentries) {
				final FileDiff d = new FileDiff(commit, m);
		String projectRelativeNewPath = getProjectRelativePath(db, getNewPath());
		String projectRelativeOldPath = getProjectRelativePath(db, getOldPath());
		d.append("diff --git ").append(projectRelativeOldPath).append(" ") //$NON-NLS-1$ //$NON-NLS-2$
				.append(projectRelativeNewPath).append("\n"); //$NON-NLS-1$
			d.append(getProjectRelativePath(db, getOldPath()));
			d.append(getProjectRelativePath(db, getNewPath()));
		IResource resource = ResourceUtil.getFileForLocation(db, repoPath);
		if (resource == null)
			return null;
	 * @deprecated Use {@link #getOldPath()} or {@link #getNewPath()}
	/**
	 * @return the new path or null for a deleted file
	 */
	public String getOldPath() {
		return diffEntry.getOldPath();
	}

	/**
	 * @return the old path or null for a completely new file
	 */
	public String getNewPath() {
		return diffEntry.getNewPath();
	}

	 * or not, see
	 * {@link #compute(Repository, TreeWalk, RevCommit, TreeFilter...)}.
	 * @param index
	 *            the tree filter index to check
		case RENAME:
			return new DecorationOverlayDescriptor(base,
					UIIcons.OVR_STAGED_RENAME, IDecoration.BOTTOM_RIGHT);